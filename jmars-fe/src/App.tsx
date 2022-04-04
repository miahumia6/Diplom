import React from 'react';
import './App.css';
import {createTheme} from "@mui/material";
import {useAppDispatch, useAppSelector} from "./app/hooks";
import {selectAuth} from "./store/loginSlice";
import {BrowserRouter} from "react-router-dom";
import AppRouter from "./components/AppRouter";
import NavigationBar from "./components/NavigationBar";

export const marsTheme = createTheme({
    palette: {
        primary: {
            // light: will be calculated from palette.primary.main,
            main: '#d73e0b',
            // main: '#ff4400',
            // dark: will be calculated from palette.primary.main,
            // contrastText: will be calculated to contrast with palette.primary.main
        },
        secondary: {
            light: '#0066ff',
            main: '#0044ff',
            // dark: will be calculated from palette.secondary.main,
            contrastText: '#ffcc00',
        },
        // Used by `getContrastText()` to maximize the contrast between
        // the background and the text.
        contrastThreshold: 3,
        // Used by the functions below to shift a color's luminance by approximately
        // two indexes within its tonal palette.
        // E.g., shift from Red 500 to Red 300 or Red 700.
        tonalOffset: 0.2,
    },
});


function App() {
    const auth = useAppSelector(selectAuth);
    const dispatch = useAppDispatch();
    console.log(auth)

    return (
        <div className="App">
            <BrowserRouter>
                <NavigationBar/>
                <AppRouter/>
            </BrowserRouter>
        </div>
    );
}

export default App;
