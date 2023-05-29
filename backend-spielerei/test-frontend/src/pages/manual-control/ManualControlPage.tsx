import ControlPanel from './ControlPanel'
import { Grid } from '@mui/material'
import GripperControlPanel from './GripperControlPanel'
import RoboSetupControlPanel from './RoboSetupControlPanel'
import SafetyStatusDisplay from '../../commons/components/SafetyStatusDisplay'
import ReadyStateDisplay from './ReadyStateDisplay'

const ManualControlPage = () => {
    console.log('war hier')
    return (
        <Grid container spacing={3} sx={{ padding: 2, maxWidth: '900px' }}>
            <ReadyStateDisplay />
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
