export type Axis = "X" | "Y" | "Z"
export type Direction = "PLUS" | "MINUS"

export type RobotCommandType = "ARM" | "TOOL"
export type RobotMove = `ROBO_${RobotCommandType}`
export type MoveType = RobotMove | "GRIPPER"
export type RobotMoveDirection = `${Axis}_${Direction}`

export type GripperCommandType = "OPEN" | "CLOSE" | "ACTIVATE"
