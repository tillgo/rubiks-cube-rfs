import { WSContext } from './commons/hooks/useAppWebSocket'
import useWebSocket from 'react-use-websocket'
import TabNav from './commons/components/TabNav'
import { AppContextProvider } from './base/appContext'
import { useCallback } from 'react'

function App() {
    const socketUrl = 'ws://localhost:8080'
    const context = useCallback(() => {
        return {
            MANUAL: useWebSocket(socketUrl + '/manual/deinmoma'),
            CUBE_SOLVER: useWebSocket(socketUrl + '/cube-solver/deinmoma'),
        }
    }, [socketUrl])

    return (
        <WSContext.Provider value={context.call(socketUrl)}>
            <AppContextProvider>
                <TabNav />
            </AppContextProvider>
        </WSContext.Provider>
    )
}

export default App
