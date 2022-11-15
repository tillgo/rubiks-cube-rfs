package de.adv.rfsprojekt.ur_new.rtde;

import de.adv.rfsprojekt.ur_new.rtde.entities.ConnectionState;
import de.adv.rfsprojekt.ur_new.rtde.entities.PacketHeader;
import de.adv.rfsprojekt.ur_new.rtde.entities.exceptions.URException;
import de.adv.rfsprojekt.ur_new.rtde.entities.exceptions.URPackageNotFoundException;
import de.adv.rfsprojekt.ur_new.rtde.entities.exceptions.URRuntimeException;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.BooleanPackage;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.ConfigPackage;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataConfig;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Geht aktuell nur mit Protokol Version 2
 */
public class RTDE {

    public final static short RTDE_PROTOCOL_VERSION_2 = 2;

    private final String hostname;

    private Socket socket = null;
    private OutputStream os = null;
    private InputStream is = null;

    private ByteBuffer buffer = null;
    private ConnectionState connectionState = ConnectionState.DISCONNECTED;

    private DataConfig outputConfig;


    public RTDE(String hostname) {
        this.hostname = hostname;
    }

    public void connect() throws Exception {
        if (socket != null) {
            return;
        }
        try {
            socket = new Socket(hostname, 30004);
            os = socket.getOutputStream();
            is = socket.getInputStream();
            connectionState = ConnectionState.CONNECTED;

        } catch (IOException e) {
            socket = null;
            os = null;
            is = null;
            throw e;
        }
        if (!negotiateProtocolVersion()) {
            throw new URException("Couldnt negotiate Protocol Version 2");
        }
    }


    public DataConfig send_output_setup(List<DataType> variables, double frequency) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        buffer.putDouble(frequency);
        String variableString = variables.stream()
                .map(DataType::getName)
                .collect(Collectors.joining(","));
        buffer.put(variableString.getBytes(StandardCharsets.UTF_8));

        //ToDo Packages über Generics lösen
        ConfigPackage configPackage = (ConfigPackage) sendAndReceive(PackageType.RTDE_CONTROL_PACKAGE_SETUP_OUTPUTS, cutOffByteBufferToCorrectSize(buffer));
        outputConfig = new DataConfig(configPackage.getPayload(), variables);
        return outputConfig;
    }

    public DataConfig send_output_setup(List<DataType> variables) throws Exception {
        return send_output_setup(variables, 125);
    }

    public boolean sendStart() throws Exception {
        boolean success = ((BooleanPackage) sendAndReceive(PackageType.RTDE_CONTROL_PACKAGE_START, ByteBuffer.allocate(0))).getPayload();
        if (success) connectionState = ConnectionState.STARTED;
        return success;
    }

    public boolean negotiateProtocolVersion() throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        byteBuffer.putShort(RTDE_PROTOCOL_VERSION_2);
        return ((BooleanPackage) sendAndReceive(PackageType.RTDE_REQUEST_PROTOCOL_VERSION, cutOffByteBufferToCorrectSize(byteBuffer))).getPayload();

    }

    public Package reveive(PackageType packageType) throws Exception {
        if (outputConfig == null) throw new URException("No Output-Variables setup");
        if (!connectionState.equals(ConnectionState.STARTED)) throw new URException("RTDE Synchronization inactive");
        return recvSpecificPackage(packageType);
    }

    /**
     * Return First Package in Buffer with given PackageType
     *
     * @param packageType
     * @throws Exception
     */
    private Package recvSpecificPackage(PackageType packageType) throws Exception {
        while (isConnected()) {
            recvToBuffer();
            while (buffer.remaining() >= 3) {
                PacketHeader ph = PacketHeader.fromByteBuffer(buffer, false);
                if (ph.packageType().getValue() == packageType.getValue()) {
                    return onPackage(packageType, buffer);

                }
            }

        }
        throw new URPackageNotFoundException();
    }

    /*private DataPackage getNewestDataPackage() throws Exception {
        DataPackage dataPackage = null;
        while (isConnected()){
            recvToBuffer();
            while (buffer.remaining()>=3){
                PacketHeader ph = PacketHeader.fromByteBuffer(buffer, false);
                if(ph.packageType().getValue() == PackageType.RTDE_DATA_PACKAGE.getValue()){
                    dataPackage = (DataPackage) onPackage(PackageType.RTDE_DATA_PACKAGE, buffer);
                }else {

                }
            }
        }
    }

     */

    private void recvToBuffer() throws Exception {
        byte[] input = new byte[4096];
        int bytesRead = is.read(input);
        byte[] message = Arrays.copyOfRange(input, 0, bytesRead);

        if (message.length == 0) {
            /*ToDo Spezifische Exception werfen und disconnecten*/
            throw new Exception();
        }
        buffer = ByteBuffer.wrap(message);
    }


    private Package sendAndReceive(PackageType packageType, ByteBuffer payload) throws Exception {
        sendAll(packageType, payload);
        return recvSpecificPackage(packageType);
    }

    private void sendAll(PackageType packageType, ByteBuffer payload) throws IOException, URException {
        if (os == null) throw new URException("No Outputstream defined");
        ByteBuffer packetHeader = ByteBuffer.allocate(3);
        short size = (short) (packetHeader.array().length + payload.array().length);
        packetHeader.putShort(size);
        packetHeader.put(packageType.getValue());
        ByteBuffer sendBuf = ByteBuffer.allocate(size);
        sendBuf.put(packetHeader.array());
        sendBuf.position(packetHeader.array().length);
        sendBuf.put(payload.array());
        os.write(sendBuf.array());
    }

    private Package onPackage(PackageType packageType, ByteBuffer payload) throws URException {
        switch (packageType) {

            case RTDE_REQUEST_PROTOCOL_VERSION -> {
                return BooleanPackage.unpack(payload);
            }
            case RTDE_GET_URCONTROL_VERSION -> {
            }
            case RTDE_TEXT_MESSAGE -> {
            }
            case RTDE_DATA_PACKAGE -> {
                return DataPackage.unpack(payload, outputConfig);
            }
            case RTDE_CONTROL_PACKAGE_SETUP_OUTPUTS -> {
                return ConfigPackage.unpack(payload);
            }
            case RTDE_CONTROL_PACKAGE_SETUP_INPUTS -> {
            }
            case RTDE_CONTROL_PACKAGE_START -> {
                return BooleanPackage.unpack(payload);
            }
            case RTDE_CONTROL_PACKAGE_PAUSE -> {
            }
        }
        throw new URRuntimeException("Package not implemented yet");

    }

    private ByteBuffer cutOffByteBufferToCorrectSize(ByteBuffer buf) {
        byte[] correctSizeArray = new byte[buf.position()];
        buf.rewind();
        buf.get(correctSizeArray);
        return ByteBuffer.wrap(correctSizeArray);
    }

    private boolean isConnected() {
        return connectionState != ConnectionState.DISCONNECTED;
    }


}
