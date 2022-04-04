import {Action, configureStore, ThunkAction} from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import authReducer from './loginSlice'
import {questionsAPI} from "../services/QuestionsService";

export const store = configureStore({
    reducer: {
        counter: counterReducer,
        auth: authReducer,
        [questionsAPI.reducerPath]: questionsAPI.reducer
    },
    middleware: (getDefaultMiddleware =>
        getDefaultMiddleware().concat(questionsAPI.middleware))
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<ReturnType,
    RootState,
    unknown,
    Action<string>>;
