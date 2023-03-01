export type Axis = 'X' | 'Y' | 'Z'
export type Direction = 'PLUS' | 'MINUS'

export type RobotCommandType = 'ARM' | 'TOOL'
export type RobotCommand = `ROBO_${RobotCommandType}`
export type MoveType = RobotCommand | 'GRIPPER' | 'ROBO_SETUP'
export type RobotMoveDirection = `${Axis}_${Direction}`

export type GripperCommandType = 'OPEN' | 'CLOSE' | 'ACTIVATE'
export type RoboSetupCommandType = 'ON' | 'OFF'

type ManualCmd<T extends MoveType> = T extends RobotCommand
    ? RobotMoveDirection
    : T extends Extract<MoveType, 'GRIPPER'>
    ? GripperCommandType
    : T extends Extract<MoveType, 'ROBO_SETUP'>
    ? RoboSetupCommandType
    : never
type ManualCommandPayload<T extends MoveType> = {
    commandType: T
    command: ManualCmd<T>
}
export type CubeSolverCommandType = 'START_SCAN' | 'START_SOLVE' | 'STOP'
type CubeSolverCommandPayload = {
    command: CubeSolverCommandType
}

export type InfoType = 'ROBO_STATUS' | 'SCAN_FINISHED' | 'CUBE_UPDATE'
export type Face = 'U' | 'D' | 'F' | 'B' | 'R' | 'L'
export type TurnCount = 1 | 2 | -1
export type SolvingStep = {
    face: Face
    count: TurnCount
}
export type ScanFinishedInfoData = {
    cubeStructure: string
    solvingPath: Array<SolvingStep>
}
export type CubeUpdateInfoData = {
    nthMove: number
    moveSum: number
    move: SolvingStep
}
type InfoData<T extends InfoType> = T extends 'ROBO_STATUS'
    ? Record<string, boolean>
    : T extends 'SCAN_FINISHED'
    ? ScanFinishedInfoData
    : T extends 'CUBE_UPDATE'
    ? CubeUpdateInfoData
    : never
export type InfoPayload<T extends InfoType> = {
    infoType: T
    data: InfoData<T>
}

type Payload<T extends MessageType, C extends WSConnection> = T extends 'ERROR'
    ? { message: string }
    : T extends 'COMMAND'
    ? C extends 'MANUAL'
        ? ManualCommandPayload<MoveType>
        : CubeSolverCommandPayload
    : T extends 'INFO'
    ? C extends 'MANUAL'
        ? InfoPayload<'ROBO_STATUS'>
        : InfoPayload<InfoType>
    : never

export type WSConnection = 'MANUAL' | 'CUBE_SOLVER'
export type MessageType = 'ERROR' | 'COMMAND' | 'INFO'
export type WebsocketMessage<T extends MessageType, C extends WSConnection> = {
    type: T
    payload: Payload<T, C>
}
