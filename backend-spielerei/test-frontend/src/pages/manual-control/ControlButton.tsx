import {MoveType, RobotMove, RobotMoveDirection, RobotMoveType} from "../../commons/types";
import {Button, IconButton} from "@mui/material";
import {controlPanelConfig} from "./controlPanelConfig";
import useWebSocket from "react-use-websocket";
import {socketUrl} from "./ManualControlPage";
import {useState} from "react";
import sleep from "../../commons/sleep";

type ControlButtonProps = {
    moveType: RobotMove
    direction: RobotMoveDirection
}

const ControlButton = (props: ControlButtonProps) => {
    const config = controlPanelConfig[props.direction]
    let buttonHold = false

    const {sendMessage} = useWebSocket(socketUrl);

    const handleMouseDown = async () => {
        buttonHold = true
        while (buttonHold) {
            sendMessage(JSON.stringify({moveType: props.moveType, moveDirection: props.direction}))
            await sleep(100)
        }
    }

    return (
        <Button
            onMouseDown={handleMouseDown}
            onMouseUp={()=> buttonHold = false}
            sx={{width: "100%", height: "100%", border: "1px solid"}}
            color={"primary"}
            variant={"outlined"}
        >
            {config.icon}
        </Button>
    )
}

export default ControlButton