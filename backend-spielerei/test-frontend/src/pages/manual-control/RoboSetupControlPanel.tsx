import { RoboSetupCommandType } from '../../commons/types'
import { Box, Button } from '@mui/material'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'

const RoboSetupControlPanel = () => {
    const [sendMessage] = useAppWebSocket('MANUAL')
    const handleClick = (type: RoboSetupCommandType) => {
        sendMessage({
            type: 'COMMAND',
            payload: {
                commandType: 'ROBO_SETUP',
                command: type,
            },
        })
    }

    return (
        <Box display={'flex'}>
            <Button
                onClick={() => handleClick('ON')}
                variant={'outlined'}
                color={'success'}
                sx={{ mr: 2 }}
            >
                ROBO ON
            </Button>
            <Button
                onClick={() => handleClick('OFF')}
                variant={'outlined'}
                color={'error'}
            >
                ROBO OFF
            </Button>
        </Box>
    )
}

export default RoboSetupControlPanel
