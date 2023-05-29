import { Box, Typography } from '@mui/material'
import ControlButton from './ControlButton'
import { RobotCommand } from '../../commons/types'

type ControlPanelProps = {
    moveType: RobotCommand
}
const ControlPanel = (props: ControlPanelProps) => {
    const { moveType } = props

    return (
        <Box
            sx={{
                display: 'grid',
                gridTemplateColumns: '1fr 1fr 1fr',
                gridTemplateRows: '1fr 1fr 1fr',
                gap: '8px',
                aspectRatio: '1/0.65',
            }}
        >
            <div>
                <ControlButton commandType={moveType} direction={'Z_MINUS'} />
            </div>
            <div>
                <ControlButton commandType={moveType} direction={'Y_PLUS'} />
            </div>
            <div>
                <ControlButton commandType={moveType} direction={'Z_PLUS'} />
            </div>
            <div>
                <ControlButton commandType={moveType} direction={'X_MINUS'} />
            </div>
            <Box
                display={'flex'}
                justifyContent={'center'}
                alignItems={'center'}
            >
                <Typography fontSize={{ xs: 14, md: 20 }}>
                    {moveType}
                </Typography>
            </Box>
            <div>
                <ControlButton commandType={moveType} direction={'X_PLUS'} />
            </div>
            <div />
            <div>
                <ControlButton commandType={moveType} direction={'Y_MINUS'} />
            </div>
            <div />
        </Box>
    )
}

export default ControlPanel
