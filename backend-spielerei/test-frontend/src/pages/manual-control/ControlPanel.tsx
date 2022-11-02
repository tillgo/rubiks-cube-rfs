import {Box, Typography} from "@mui/material";
import ControlButton from "./ControlButton";
import {RobotMove} from "../../commons/types";

type ControlPanelProps = {
    moveType: RobotMove
}
const ControlPanel = (props: ControlPanelProps) => {

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
            <div><ControlButton moveType={props.moveType} direction={"Z_MINUS"}/></div>
            <div><ControlButton moveType={props.moveType} direction={"Y_PLUS"}/></div>
            <div><ControlButton moveType={props.moveType} direction={"Z_PLUS"}/></div>
            <div><ControlButton moveType={props.moveType} direction={"X_MINUS"}/></div>
            <Box display={"flex"} justifyContent={"center"} alignItems={"center"}>
                <Typography fontSize={{xs: 14, md: 20}}>{props.moveType}</Typography>
            </Box>
            <div><ControlButton moveType={props.moveType} direction={"X_PLUS"}/></div>
            <div/>
            <div><ControlButton moveType={props.moveType} direction={"Y_MINUS"}/></div>
            <div/>
        </Box>
    )
}

export default ControlPanel