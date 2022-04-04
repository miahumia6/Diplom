import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {RootState} from "./store";

export interface LoginState {
    status: boolean;
    role: 'admin' | 'user' | null;
}

const initialState: LoginState = {
    status: true,
    role: 'admin'
};


export const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        login: (state, action: PayloadAction<string>) => {
            action.payload.includes('admin')
                ? state.role = 'admin'
                : state.role = 'user';

            state.status = true;
        },
        logout: (state) => {
            state.status = false;
        },
    },
});

export const {login, logout} = authSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.counter.value)`
export const selectAuth = (state: RootState) => state.auth.status;
export const selectRole = (state: RootState) => state.auth.role;


export default authSlice.reducer;
