import {RobotMoveDirection} from "../../commons/types";
import {ReactNode} from "react";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import ArrowUpwardIcon from '@mui/icons-material/ArrowUpward';
import ArrowDownwardIcon from '@mui/icons-material/ArrowDownward';
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';
import NorthIcon from '@mui/icons-material/North';
import SouthIcon from '@mui/icons-material/South';

type ControlButtonConfig = {
    icon: ReactNode
}
type ControlPanelConfig = Record<RobotMoveDirection, ControlButtonConfig>
export const controlPanelConfig: ControlPanelConfig = {
    "X+": {icon: <ArrowForwardIcon sx={{fontSize: 36}} />},
    "X-": {icon: <ArrowBackIcon sx={{fontSize: 36}} />},
    "Y+": {icon: <ArrowUpwardIcon sx={{fontSize: 36}} />},
    "Y-": {icon: <ArrowDownwardIcon sx={{fontSize: 36}} />},
    "Z+": {icon: <NorthIcon sx={{fontSize: 36}} />},
    "Z-": {icon: <SouthIcon sx={{fontSize: 36}} />}

}