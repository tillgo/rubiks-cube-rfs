/* eslint-disable @typescript-eslint/no-explicit-any */
import { Dispatch, useReducer } from 'react'

export type PayloadAction<P, T extends string = string> = {
    payload: P
    type: T
}
export type CaseReducer<
    State,
    Name extends string,
    A extends PayloadAction<any, Name>
> = (state: State, action: A) => State

export type AnyCaseReducers<State> = {
    [K: string]: CaseReducer<State, typeof K, PayloadAction<any, typeof K>>
}

export type ReducerOptions<
    State,
    CaseReducers extends AnyCaseReducers<State>
> = {
    initialState: State
    reducers: CaseReducers
}

type PayloadActionCreator<P, T extends string = string> = (
    payload: P
) => PayloadAction<P, T>
type NonPayloadActionCreator<T extends string = string> = () => PayloadAction<
    undefined,
    T
>
type ActionCreatorForCaseReducer<CR, T extends string> = CR extends (
    state: any,
    action: infer Action
) => any
    ? Action extends { payload: infer P }
        ? PayloadActionCreator<P, T>
        : NonPayloadActionCreator<T>
    : NonPayloadActionCreator<T>

export type ReducerActions<CaseReducers extends AnyCaseReducers<any>> = {
    [T in keyof CaseReducers]: T extends string
        ? ActionCreatorForCaseReducer<CaseReducers[T], T>
        : never
}

type ActionsFromCaseReducer<
    State,
    CaseReducers extends AnyCaseReducers<State>
> = {
    [K in keyof CaseReducers]: {
        type: K
        payload: Parameters<CaseReducers[K]>[1]['payload']
    }
}

type ActionsUnion<
    State,
    CaseReducers extends AnyCaseReducers<State>
> = ActionsFromCaseReducer<State, CaseReducers>[keyof CaseReducers]

export type Reducer<
    State = any,
    CaseReducers extends AnyCaseReducers<State> = AnyCaseReducers<State>
> = {
    useReducer: () => [State, Dispatch<ActionsUnion<State, CaseReducers>>]
    actions: ReducerActions<CaseReducers>
}

export const createReducer = <State, Reducers extends AnyCaseReducers<State>>(
    opts: ReducerOptions<State, Reducers>
): Reducer<State, Reducers> => {
    function reducer(prevState: State, action: PayloadAction<any>) {
        return opts.reducers[action.type]?.(prevState, action) ?? prevState
    }

    const reducerNames = Object.keys(opts.reducers)
    const actionCreators = reducerNames.reduce((prev: any, reducerName) => {
        prev[reducerName] = (p: any) => ({ type: reducerName, payload: p })
        return prev
    }, {})

    return {
        useReducer: () => {
            const [state, dispatch] = useReducer(reducer, opts.initialState)
            return [state, dispatch] as any
        },
        actions: actionCreators as any,
    }
}
