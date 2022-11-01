import {MoveType, RobotMove, RobotMoveDirection, RobotMoveType} from "../../commons/types";
import {Button, IconButton} from "@mui/material";
import {controlPanelConfig} from "./controlPanelConfig";
import useWebSocket from "react-use-websocket";
import {socketUrl} from "./ManualControlPage";

type ControlButtonProps = {
    moveType: RobotMove
    direction: RobotMoveDirection
}

const ControlButton = (props: ControlButtonProps) => {
    const config = controlPanelConfig[props.direction]

    const {sendMessage} = useWebSocket(socketUrl);

    const handleClick = () => {
        sendMessage(JSON.stringify({moveType: props.moveType, moveDirection: props.direction}))
    }

    return (
        <Button
            onClick={handleClick}
            sx={{width: "100%", height: "100%", border: "1px solid"}}
            color={"primary"}
            variant={"outlined"}
        >
            {config.icon}
        </Button>
    )
}

export default ControlButton