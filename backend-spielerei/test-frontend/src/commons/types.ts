export type Axis = "X" | "Y" | "Z"
export type Direction = "+" | "-"

export type RobotMoveType = "ARM" | "TOOL"
export type RobotMove = `ROBO_${RobotMoveType}`
export type MoveType = RobotMove | "GRIPPER"
export type RobotMoveDirection = `${Axis}${Direction}`

export type GripperMoveDirection = "OPEN" | "CLOSE"
