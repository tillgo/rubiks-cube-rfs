import ManualControlPage from './pages/manual-control/ManualControlPage'
import { WSContext } from './commons/hooks/useAppWebSocket'
import useWebSocket from 'react-use-websocket'

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
            <ManualControlPage />
        </WSContext.Provider>
    )
}

export default App
