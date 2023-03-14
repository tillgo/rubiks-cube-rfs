import { MessageType, WebsocketMessage, WSConnection } from '../types'
import { createContext, useContext } from 'react'
import { JsonValue, WebSocketHook } from 'react-use-websocket/dist/lib/types'
import { ReadyState } from 'react-use-websocket'

type UseWSHookType = WebSocketHook<JsonValue | null, MessageEvent<any> | null>
export const WSContext = createContext<Record<
    WSConnection,
    UseWSHookType
> | null>(null)

type ReturnType<T extends WSConnection> = [
    (m: WebsocketMessage<MessageType, T>) => void,
    {
        data: WebsocketMessage<any, T> | undefined
        readyState: UseWSHookType['readyState']
    }
]
export const useAppWebSocket = <T extends WSConnection>(
    type: T
): ReturnType<T> => {
    const socket = useContext(WSContext)

    if (socket) {
        const { sendMessage: send, readyState, lastMessage } = socket[type]

        const sendMessage = (message: WebsocketMessage<MessageType, T>) => {
            send(JSON.stringify(message))
        }
        const data = lastMessage?.data
            ? (JSON.parse(lastMessage?.data) as WebsocketMessage<any, T>)
            : undefined

        return [sendMessage, { data, readyState }]
    }

    return [
        () => {
            console.error('Wartsch mal gschwind eyy')
        },
        { data: undefined, readyState: ReadyState.CONNECTING },
    ]
}
