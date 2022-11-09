export type Axis = "X" | "Y" | "Z"
export type Direction = "PLUS" | "MINUS"

export type RobotMoveType = "ARM" | "TOOL"
export type RobotMove = `ROBO_${RobotMoveType}`
export type MoveType = RobotMove | "GRIPPER"
export type RobotMoveDirection = `${Axis}_${Direction}`

export type GripperMoveDirection = "OPEN" | "CLOSE"
