import ManualControlPage from './pages/manual-control/ManualControlPage'
import { WSContext } from './commons/hooks/useAppWebSocket'
import useWebSocket from 'react-use-websocket'

function App() {
    const socketUrl = 'ws://localhost:8080/manual/deinmoma'
    const defaultWSContext = () => {
        const manual = useWebSocket(socketUrl)
        return {
            MANUAL: manual,
            CUBE_SOLVER: manual,
        }
    }
    return (
        <WSContext.Provider value={defaultWSContext()}>
            <ManualControlPage />
        </WSContext.Provider>
    )
}

export default App
