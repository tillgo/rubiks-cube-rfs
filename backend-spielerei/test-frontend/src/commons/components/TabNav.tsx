import { Box, Tab, Tabs } from '@mui/material'
import { ReactNode, SyntheticEvent, useState } from 'react'
import ManualControlPage from '../../pages/manual-control/ManualControlPage'
import RubiksSolvePage from '../../pages/rubiks-solve/RubiksSolvePage'

type TabPanelProps = {
    children?: ReactNode
    index: number
    value: number
}

function TabPanel(props: TabPanelProps) {
    const { children, value, index, ...other } = props

    return (
        <Box
            role="tabpanel"
            hidden={value !== index}
            sx={{ display: 'flex', justifyContent: 'center', width: '100%' }}
            {...other}
        >
            {value === index && children}
        </Box>
    )
}

const TabNav = () => {
    const [value, setValue] = useState(0)

    const handleChange = (event: SyntheticEvent, newValue: number) => {
        setValue(newValue)
    }

    return (
        <Box sx={{ width: '100vw' }}>
            <Tabs value={value} onChange={handleChange}>
                <Tab
                    label="Manuelle Steuerung"
                    aria-controls="simple-tabpanel-1"
                />
                <Tab label="Rubiks Löser" aria-controls="simple-tabpanel-2" />
            </Tabs>
            <TabPanel value={value} index={0}>
                <ManualControlPage />
            </TabPanel>
            <TabPanel value={value} index={1}>
                <RubiksSolvePage />
            </TabPanel>
        </Box>
    )
}

export default TabNav
