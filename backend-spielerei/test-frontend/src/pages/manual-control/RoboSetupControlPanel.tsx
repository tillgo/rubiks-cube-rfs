import { SendMessage } from 'react-use-websocket'
import { GripperCommandType, RoboSetupCommandType } from '../../commons/types'
import { Box, Button } from '@mui/material'

export type RoboSetupControlPanelProps = {
    sendMessage: SendMessage
}

const RoboSetupControlPanel = (props: RoboSetupControlPanelProps) => {
    const {sendMessage} = props;

    const handleClick = (type: RoboSetupCommandType) => {
        sendMessage(JSON.stringify({commandType: "ROBO_SETUP", command: type}))
    }

    return (
        <Box display={"flex"}>
            <Button
                onClick={() => handleClick("ON")}
                variant={"outlined"}
                color={"success"}
                sx={{mr: 2}}
            >
                ROBO ON
            </Button>
            <Button
                onClick={() => handleClick("OFF")}
                variant={"outlined"}
                color={"error"}
                sx={{mr: 2}}
            >
                ROBO OFF
            </Button>

        </Box>
    )
}

export default RoboSetupControlPanel