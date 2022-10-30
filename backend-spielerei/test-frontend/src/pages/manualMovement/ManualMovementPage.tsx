import MovePad from "./MovePad";
import {useCallback, useEffect, useState} from "react";
import useWebSocket, {ReadyState} from "react-use-websocket";

const ManualMovementPage = () => {

    const [socketUrl, setSocketUrl] = useState('ws://localhost:8080/manual/deinmoma')

    const { sendMessage, lastMessage, readyState } = useWebSocket(socketUrl);



    const connectionStatus = {
        [ReadyState.CONNECTING]: 'Connecting',
        [ReadyState.OPEN]: 'Open',
        [ReadyState.CLOSING]: 'Closing',
        [ReadyState.CLOSED]: 'Closed',
        [ReadyState.UNINSTANTIATED]: 'Uninstantiated',
    }[readyState];

    return(
        <>
        <MovePad sendMessage={sendMessage}/>
    <div>{connectionStatus}</div>
        </>
    )
}

export default ManualMovementPage