package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data;

import de.adv.rfsprojekt.ur_new.rtde.entities.exceptions.URException;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigPackage extends Package {
    private int id;
    private List<VariableType> variableTypes;

    public ConfigPackage(int id, List<VariableType> variableTypes) {
        super(PackageType.RTDE_CONTROL_PACKAGE_SETUP_OUTPUTS);
        this.id = id;
        this.variableTypes = variableTypes;

    }

    public static ConfigPackage unpack(ByteBuffer buffer) throws URException {
        int id = buffer.get();
        String types = new String(Arrays.copyOfRange(buffer.array(), buffer.position(), buffer.array().length), StandardCharsets.UTF_8);
        List<VariableType> varTypesTemp = new ArrayList<>();
        for (String s : types.split(",")) {
            if (s.equals("NOT_FOUND"))
                throw new URException("Error while setting Output Variables: Robo returned NOT_FOUND");
            varTypesTemp.add(VariableType.valueOfLabel(s));
        }
        return new ConfigPackage(id, varTypesTemp);
    }

    public int getId() {
        return id;
    }


    @Override
    public List<VariableType> getPayload() {
        return variableTypes;
    }
}
