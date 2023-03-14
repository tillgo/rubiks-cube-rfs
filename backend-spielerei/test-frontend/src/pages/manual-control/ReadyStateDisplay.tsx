import { Grid, Typography } from '@mui/material'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'
import { ReadyState } from 'react-use-websocket'

const ReadyStateDisplay = () => {
    const [, { readyState }] = useAppWebSocket('MANUAL')
    const connectionStatus = ReadyState[readyState]

    return (
        <Grid item xs={12} display={'flex'} justifyContent={'center'}>
            <Typography color={'black'}>
                Connection Status: <b>{connectionStatus}</b>
            </Typography>
        </Grid>
    )
}

export default ReadyStateDisplay
