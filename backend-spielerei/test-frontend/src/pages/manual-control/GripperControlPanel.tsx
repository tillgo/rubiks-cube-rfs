import {Box, Button} from "@mui/material";
import useWebSocket from "react-use-websocket";
import {socketUrl} from "./ManualControlPage";
import {GripperMoveDirection} from "../../commons/types";

const GripperControlPanel = () => {
    const {sendMessage} = useWebSocket(socketUrl);

    const handleClick = (type: GripperMoveDirection) => {
        sendMessage(JSON.stringify({moveType: "GRIPPER", moveDirection: type}))
    }

    return (
        <Box display={"flex"}>
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