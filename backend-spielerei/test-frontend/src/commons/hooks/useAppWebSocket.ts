import { MessageType, WebsocketMessage, WSConnection } from '../types'
import { createContext, useContext } from 'react'
import { JsonValue, WebSocketHook } from 'react-use-websocket/dist/lib/types'
import { ReadyState } from 'react-use-websocket'

type UseWSHookType = WebSocketHook<JsonValue | null, MessageEvent<any> | null>
export const WSContext = createContext<Record<
    WSConnection,
    UseWSHookType
> | null>(null)

type ReturnType<T extends WSConnection> = Pick<
    UseWSHookType,
    'lastMessage' | 'readyState'
> & {
    sendMessage: (m: WebsocketMessage<MessageType, T>) => void
}
export const useAppWebSocket = <T extends WSConnection>(
    type: T
): ReturnType<T> => {
    const socket = useContext(WSContext)

    if (socket) {
        const { sendMessage: send, readyState, lastMessage } = socket[type]

        const sendMessage = (message: WebsocketMessage<MessageType, T>) => {
            send(JSON.stringify(message))
        }

        return {
            sendMessage,
            readyState,
            lastMessage,
        }
    }

    return {
        sendMessage: () => {
            console.error('Wartsch mal gschwind eyy')
        },
        readyState: ReadyState.CONNECTING,
        lastMessage: null,
    }
}
