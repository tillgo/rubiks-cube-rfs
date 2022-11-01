import useWebSocket, {ReadyState} from "react-use-websocket";
import ControlPanel from "./ControlPanel";
import {Grid, Typography} from "@mui/material";
import GripperControlPanel from "./GripperControlPanel";

export const socketUrl = 'ws://localhost:8080/manual/deinmoma'

const ManualControlPage = () => {
    const {readyState} = useWebSocket(socketUrl)
    const connectionStatus = ReadyState[readyState]

    return (
        <Grid container spacing={4} sx={{padding: 2, maxWidth: "900px"}}>
            <Grid item xs={12} display={"flex"} justifyContent={"center"}>
                <Typography color={"black"}>Connection Status: <b>{connectionStatus}</b></Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
                <ControlPanel moveType={"ROBO_ARM"}/>
            </Grid>
            <Grid item xs={12} sm={6}>
                <ControlPanel moveType={"ROBO_TOOL"}/>
            </Grid>
            <Grid item xs={12} display={"flex"} justifyContent={"center"}>
                <GripperControlPanel />
            </Grid>
        </Grid>
    )

}

export default ManualControlPage