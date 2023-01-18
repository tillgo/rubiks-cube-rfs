import { Box, Button } from '@mui/material'
import { GripperCommandType } from '../../commons/types'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'

const GripperControlPanel = () => {
    const { sendMessage } = useAppWebSocket('MANUAL')
    const handleClick = (type: GripperCommandType) => {
        sendMessage({
            type: 'COMMAND',
            payload: {
                commandType: 'GRIPPER',
                command: type,
            },
        })
    }

    return (
        <Box display={'flex'}>
            <Button
                onClick={() => handleClick('ACTIVATE')}
                variant={'outlined'}
                color={'secondary'}
                sx={{ mr: 2 }}
            >
                ACTIVATE GRIPPER
            </Button>
            <Button
                onClick={() => handleClick('OPEN')}
                variant={'outlined'}
                color={'secondary'}
                sx={{ mr: 2 }}
            >
                GRIPPER OPEN
            </Button>
            <Button
                onClick={() => handleClick('CLOSE')}
                variant={'outlined'}
                color={'secondary'}
            >
                GRIPPER CLOSE
            </Button>
        </Box>
    )
}

export default GripperControlPanel
