import { Typography } from '@mui/material'
import { useAppSelector } from '../../base/appContext'

const Cube = () => {
    const cube = useAppSelector((s) => s.cube)

    return (
        <Typography>
            <b>Gescannter Cube:</b> {cube ?? '-'}
        </Typography>
    )
}

export default Cube
