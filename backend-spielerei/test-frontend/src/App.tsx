import { WSContext } from './commons/hooks/useAppWebSocket'
import useWebSocket from 'react-use-websocket'
import TabNav from './commons/components/TabNav'
import { AppContextProvider } from './base/appContext'

function App() {
    const socketUrl = 'ws://localhost:8080'
    const defaultWSContext = () => {
        const manual = useWebSocket(socketUrl + '/manual/deinmoma')
        const cubeSolver = useWebSocket(socketUrl + '/cube-solver/deinmoma')
        return {
            MANUAL: manual,
            CUBE_SOLVER: cubeSolver,
        }
    }

    return (
        <WSContext.Provider value={defaultWSContext()}>
            <AppContextProvider>
                <TabNav />
            </AppContextProvider>
        </WSContext.Provider>
    )
}

export default App
