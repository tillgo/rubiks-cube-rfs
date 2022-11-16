import {Box, Button} from "@mui/material";
import useWebSocket, {SendMessage} from "react-use-websocket";
import {socketUrl} from "./ManualControlPage";
import {GripperCommandType} from "../../commons/types";

type GripperControlPanelProps = {
    sendMessage: SendMessage
}

const GripperControlPanel = (props: GripperControlPanelProps) => {
    const {sendMessage} = props;

    const handleClick = (type: GripperCommandType) => {
        sendMessage(JSON.stringify({moveType: "GRIPPER", command: type}))
    }

    return (
        <Box display={"flex"}>
            <Button
                onClick={() => handleClick("ACTIVATE")}
                variant={"outlined"}
                color={"secondary"}
                sx={{mr: 2}}
            >
                ACTIVATE GRIPPER
            </Button>
            <Button
                onClick={() => handleClick("OPEN")}
                variant={"outlined"}
                color={"secondary"}
                sx={{mr: 2}}
            >
                GRIPPER OPEN
            </Button>
            <Button onClick={() => handleClick("CLOSE")} variant={"outlined"} color={"secondary"}>
                GRIPPER CLOSE
            </Button>
        </Box>
    )
}

export default GripperControlPanel