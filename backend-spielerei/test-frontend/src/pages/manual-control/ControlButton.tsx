import {
    MoveType,
    RobotCommand,
    RobotMoveDirection,
    RobotCommandType,
} from '../../commons/types'
import { Button, IconButton } from '@mui/material'
import { controlPanelConfig } from './controlPanelConfig'
import useWebSocket, { SendMessage } from 'react-use-websocket'
import { socketUrl } from './ManualControlPage'
import { useState } from 'react'
import sleep from '../../commons/sleep'

type ControlButtonProps = {
    commandType: RobotCommand
    direction: RobotMoveDirection
    sendMessage: SendMessage
}

const ControlButton = (props: ControlButtonProps) => {
    const config = controlPanelConfig[props.direction]
    const { sendMessage } = props
    let buttonHold = false

    const handleMouseDown = async () => {
        buttonHold = true
        while (buttonHold) {
            sendMessage(
                JSON.stringify({
                    commandType: props.commandType,
                    command: props.direction,
                })
            )
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
