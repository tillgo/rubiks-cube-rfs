import { ReadyState } from 'react-use-websocket'
import { Grid, Typography } from '@mui/material'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'
import SafetyStatusDisplay from '../../commons/components/SafetyStatusDisplay'
import RubiksSolveButtons from './RubiksSolveButtons'
import { InfoPayload, WebsocketMessage } from '../../commons/types'
import { useEffect } from 'react'
import { useAppDispatch } from '../../base/appContext'
import Cube from './Cube'
import SolvingSteps from './SolvingSteps'

const RubiksSolvePage = () => {
    const { readyState, data } = useAppWebSocket('CUBE_SOLVER')
    const connectionStatus = ReadyState[readyState]

    const dispatch = useAppDispatch()

    const isInfo = (
        value: any
    ): value is WebsocketMessage<'INFO', 'CUBE_SOLVER'> =>
        value?.type === 'INFO'

    const isCubeUpdate = (
        value: WebsocketMessage<'INFO', 'CUBE_SOLVER'>['payload']
    ): value is InfoPayload<'CUBE_UPDATE'> => value?.infoType === 'CUBE_UPDATE'
    const isScanFinished = (
        value: WebsocketMessage<'INFO', 'CUBE_SOLVER'>['payload']
    ): value is InfoPayload<'SCAN_FINISHED'> =>
        value?.infoType === 'SCAN_FINISHED'

    useEffect(() => {
        const newData = isInfo(data) ? data : undefined
        const payload = newData?.payload

        if (payload) {
            if (isCubeUpdate(payload)) {
                dispatch({ type: 'updateCube', payload: payload.data })
            } else if (isScanFinished(payload)) {
                dispatch({ type: 'updateScanFinished', payload: payload.data })
            }
        }
    }, [data])

    return (
        <Grid container spacing={3} sx={{ padding: 2 }}>
            <Grid item xs={12} display={'flex'} justifyContent={'center'}>
                <Typography color={'black'}>
                    Connection Status: <b>{connectionStatus}</b>
                </Typography>
            </Grid>
            <Grid item xs={12}>
                <SafetyStatusDisplay />
            </Grid>
            <Grid item xs={12} display={'flex'} justifyContent={'center'}>
                <Cube />
            </Grid>
            <Grid item xs={12} display={'flex'} justifyContent={'center'}>
                <SolvingSteps />
            </Grid>
            <Grid container item xs={12} justifyContent={'center'}>
                <RubiksSolveButtons />
            </Grid>
        </Grid>
    )
}

export default RubiksSolvePage
