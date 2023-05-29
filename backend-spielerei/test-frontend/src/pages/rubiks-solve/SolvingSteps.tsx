import {
    Box,
    List,
    ListItem,
    ListItemButton,
    ListItemIcon,
    ListItemText,
    Typography,
} from '@mui/material'
import { useAppSelector } from '../../base/appContext'
import { TurnCount } from '../../commons/types'
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos'

const SolvingSteps = () => {
    const nthMove = useAppSelector((s) => s.nthMove)
    const moves = useAppSelector((s) => s.moveList)
    const isCubeScanned = useAppSelector((s) => s.isCubeScanned)
    const isCubeSolved = useAppSelector((s) => s.isCubeSolved)

    const getTurnBez = (count: TurnCount) => {
        return count === 1 ? '90°' : count === 2 ? '180°' : '-90°'
    }

    return (
        <Box>
            <Typography>
                Lösungsschritt:{' '}
                <b>
                    {nthMove} von {moves.length ?? 'unbekannt'}
                </b>
            </Typography>
            <List>
                {moves.map((m, index) => (
                    <ListItem disablePadding>
                        <ListItemButton disableRipple disableTouchRipple>
                            <ListItemText
                                sx={{
                                    color:
                                        index + 1 === nthMove
                                            ? 'blue'
                                            : undefined,
                                }}
                                primary={`${index + 1}. Face: ${
                                    m.face
                                } - Drehung: ${getTurnBez(m.count)}`}
                            />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
        </Box>
    )
}

export default SolvingSteps
