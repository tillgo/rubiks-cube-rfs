import { ReadyState } from 'react-use-websocket'
import ControlPanel from './ControlPanel'
import { Grid, Typography } from '@mui/material'
import GripperControlPanel from './GripperControlPanel'
import RoboSetupControlPanel from './RoboSetupControlPanel'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'
import SafetyStatusDisplay from './SafetyStatusDisplay'

const ManualControlPage = () => {
    const { readyState } = useAppWebSocket('MANUAL')
    const connectionStatus = ReadyState[readyState]

    return (
        <Grid container spacing={3} sx={{ padding: 2, maxWidth: '900px' }}>
            <Grid item xs={12} display={'flex'} justifyContent={'center'}>
                <Typography color={'black'}>
                    Connection Status: <b>{connectionStatus}</b>
                </Typography>
            </Grid>
            <Grid item xs={12}>
                <SafetyStatusDisplay />
            </Grid>
            <Grid item xs={12} sm={6}>
                <ControlPanel moveType={'ROBO_ARM'} />
            </Grid>
            <Grid item xs={12} sm={6}>
                <ControlPanel moveType={'ROBO_TOOL'} />
            </Grid>
            <Grid
                item
                xs={12}
                sm={6}
                display={'flex'}
                justifyContent={'center'}
            >
                <RoboSetupControlPanel />
            </Grid>
            <Grid
                item
                xs={12}
                sm={6}
                display={'flex'}
                justifyContent={'center'}
            >
                <GripperControlPanel />
            </Grid>
        </Grid>
    )
}

export default ManualControlPage
