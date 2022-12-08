import { RobotCommand, RobotMoveDirection } from '../../commons/types'
import { Button } from '@mui/material'
import { controlPanelConfig } from './controlPanelConfig'
import sleep from '../../commons/sleep'
import { useAppWebSocket } from '../../commons/hooks/useAppWebSocket'

type ControlButtonProps = {
    commandType: RobotCommand
    direction: RobotMoveDirection
}

const ControlButton = (props: ControlButtonProps) => {
    const { sendMessage } = useAppWebSocket('MANUAL')

    const config = controlPanelConfig[props.direction]
    let buttonHold = false

    const handleMouseDown = async () => {
        buttonHold = true
        while (buttonHold) {
            sendMessage({
                type: 'COMMAND',
                payload: {
                    commandType: props.commandType,
                    command: props.direction,
                },
            })
            await sleep(30)
        }
    }

    return (
        <Button
            onMouseDown={handleMouseDown}
            onMouseUp={() => (buttonHold = false)}
            sx={{ width: '100%', height: '100%', border: '1px solid' }}
            color={'primary'}
            variant={'outlined'}
        >
            {config.icon}
        </Button>
    )
}

export default ControlButton
