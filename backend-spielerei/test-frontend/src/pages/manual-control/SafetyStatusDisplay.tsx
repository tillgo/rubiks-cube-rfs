import { Alert, Stack } from '@mui/material'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'
import { WebsocketMessage } from '../../commons/types'

const SafetyStatusDisplay = () => {
    const { data } = useAppWebSocket('MANUAL')

    const isInfo = (value: any): value is WebsocketMessage<'INFO', 'MANUAL'> =>
        value?.type === 'INFO'

    const safetyStatus = isInfo(data) ? data.payload.data : undefined

    const errors = Object.entries(safetyStatus ?? [])
        .filter((e) => e[1])
        .filter((e) => e[0] !== 'NORMAL_MODE')
        .map((e) => e[0])

    return (
        <Stack spacing={0.5}>
            {errors.map((error) => (
                <Alert key={error} severity="error">
                    {error}
                </Alert>
            ))}
        </Stack>
    )
}

export default SafetyStatusDisplay
