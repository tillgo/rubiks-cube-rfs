export type Axis = 'X' | 'Y' | 'Z'
export type Direction = 'PLUS' | 'MINUS'

export type RobotCommandType = 'ARM' | 'TOOL'
export type RobotCommand = `ROBO_${RobotCommandType}`
export type MoveType = RobotCommand | 'GRIPPER' | 'ROBO_SETUP'
export type RobotMoveDirection = `${Axis}_${Direction}`

export type GripperCommandType = 'OPEN' | 'CLOSE' | 'ACTIVATE'
export type RoboSetupCommandType = 'ON' | 'OFF'

type CommandPayloadCmd<T extends MoveType> = T extends RobotCommand
    ? RobotMoveDirection
    : T extends Extract<MoveType, 'GRIPPER'>
    ? GripperCommandType
    : T extends Extract<MoveType, 'ROBO_SETUP'>
    ? RoboSetupCommandType
    : never
type CommandPayload<T extends MoveType> = {
    commandType: T
    command: CommandPayloadCmd<T>
}
export type InfoPayload = {
    // TODO: Generic machen
    infoType: 'ROBO_STATUS'
    safetyStatus: Record<string, boolean>
}

type Payload<T extends MessageType, C extends WSConnection> = T extends 'ERROR'
    ? { message: string }
    : T extends 'COMMAND'
    ? C extends 'MANUAL'
        ? CommandPayload<MoveType>
        : never
    : T extends 'INFO'
    ? InfoPayload
    : never

export type WSConnection = 'MANUAL' | 'CUBE_SOLVER'
export type MessageType = 'ERROR' | 'COMMAND' | 'INFO'
export type WebsocketMessage<T extends MessageType, C extends WSConnection> = {
    type: T
    payload: Payload<T, C>
}
