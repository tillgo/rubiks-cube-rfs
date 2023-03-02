import { createReducerContext, PayloadAction } from '../commons/reducerContext'
import {
    CubeUpdateInfoData,
    ScanFinishedInfoData,
    SolvingStep,
} from '../commons/types'

type AppContextType = {
    cube: string | undefined
    currentMove: SolvingStep | undefined
    moveList: Array<SolvingStep>
    nthMove: number
    moveSum: number | undefined
    isCubeScanned: boolean
    isCubeSolved: boolean
}

const initialState: AppContextType = {
    cube: undefined,
    currentMove: undefined,
    moveList: [],
    nthMove: 0,
    moveSum: undefined,
    isCubeScanned: false,
    isCubeSolved: false,
}

const appContext = createReducerContext({
    initialState: initialState,
    reducers: {
        updateScanFinished: (
            state,
            action: PayloadAction<ScanFinishedInfoData>
        ) => {
            const payload = action.payload
            return {
                ...state,
                cube: payload.cubeStructure,
                moveList: payload.solvingPath,
                isCubeScanned: true,
            }
        },
        updateCube: (state, action: PayloadAction<CubeUpdateInfoData>) => {
            const payload = action.payload
            return {
                ...state,
                currentMove: payload.move,
                nthMove: payload.nthMove,
                moveSum: payload.moveSum,
                isCubeSolved: payload.nthMove === payload.moveSum,
            }
        },
    },
})

export const {
    ContextProvider: AppContextProvider,
    useActionDispatch: useAppDispatch,
    useValue: useAppValue,
    useSelector: useAppSelector,
} = appContext
