import {Box, Typography} from "@mui/material";
import ControlButton from "./ControlButton";
import {RobotCommand} from "../../commons/types";
import {SendMessage} from "react-use-websocket";

type ControlPanelProps = {
    moveType: RobotCommand
    sendMessage: SendMessage
}
const ControlPanel = (props: ControlPanelProps) => {

    const {sendMessage, moveType} = props

    return (
        <Box
            sx={{
                display: "grid",
                gridTemplateColumns: '1fr 1fr 1fr',
                gridTemplateRows: '1fr 1fr 1fr',
                gap: "8px",
                aspectRatio: "1/0.65"
            }}
        >
            <div><ControlButton moveType={moveType} direction={"Z_MINUS"} sendMessage={sendMessage}/></div>
            <div><ControlButton moveType={moveType} direction={"Y_PLUS"} sendMessage={sendMessage}/></div>
            <div><ControlButton moveType={moveType} direction={"Z_PLUS"} sendMessage={sendMessage}/></div>
            <div><ControlButton moveType={moveType} direction={"X_MINUS"} sendMessage={sendMessage}/></div>
            <Box display={"flex"} justifyContent={"center"} alignItems={"center"}>
                <Typography fontSize={{xs: 14, md: 20}}>{moveType}</Typography>
            </Box>
            <div><ControlButton moveType={moveType} direction={"X_PLUS"} sendMessage={sendMessage}/></div>
            <div/>
            <div><ControlButton moveType={moveType} direction={"Y_MINUS"} sendMessage={sendMessage}/></div>
            <div/>
        </Box>
    )
}

export default ControlPanel