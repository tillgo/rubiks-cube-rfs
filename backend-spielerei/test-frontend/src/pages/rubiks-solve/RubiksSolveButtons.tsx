import { CubeSolverCommandType } from '../../commons/types'
import { Box, Button } from '@mui/material'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'

const RubiksSolveButtons = () => {
    const [sendMessage] = useAppWebSocket('CUBE_SOLVER')
    const handleClick = (type: CubeSolverCommandType) => {
        sendMessage({
            type: 'COMMAND',
            payload: {
                command: type,
            },
        })
    }

    return (
        <Box display={'flex'}>
            <Button
                onClick={() => handleClick('START_SCAN')}
                variant={'outlined'}
                color={'success'}
                sx={{ mr: 2 }}
            >
                START SCAN
            </Button>
            <Button
                onClick={() => handleClick('START_SOLVE')}
                variant={'outlined'}
                color={'success'}
                sx={{ mr: 2 }}
            >
                START SOLVE
            </Button>
            <Button
                onClick={() => handleClick('STOP')}
                variant={'outlined'}
                color={'error'}
            >
                STOP
            </Button>
        </Box>
    )
}

export default RubiksSolveButtons
