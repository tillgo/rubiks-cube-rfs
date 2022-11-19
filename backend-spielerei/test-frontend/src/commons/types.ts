export type Axis = "X" | "Y" | "Z"
export type Direction = "PLUS" | "MINUS"

export type RobotCommandType = "ARM" | "TOOL"
export type RobotCommand = `ROBO_${RobotCommandType}`
export type MoveType = RobotCommand | "GRIPPER" | "ROBO_SETUP"
export type RobotMoveDirection = `${Axis}_${Direction}`

export type GripperCommandType = "OPEN" | "CLOSE" | "ACTIVATE"
export type RoboSetupCommandType = "ON" | "OFF"
