import React, {useState} from 'react';
import {useAppDispatch} from "../app/hooks";
import {useNavigate} from "react-router-dom";
import {Box, Button, Container, Stack, TextField, ThemeProvider, Typography} from "@mui/material";
import {marsTheme} from "../App";
import {login} from "../store/loginSlice";

const LoginPage = () => {
    const dispatch = useAppDispatch();
    const navigate = useNavigate();
    const [loginValue, setLoginValue] = useState("");

    console.log(loginValue)

    const handleLogin = (e: any) => {
        e.preventDefault()
        dispatch(login(loginValue))
        navigate("/", {replace: true})
    }

    return (
        <div>
            <ThemeProvider theme={marsTheme}>
                <Container>
                    <Box display="flex"
                         justifyContent="center"
                         marginTop='20px'
                         marginBottom='100px'
                    >
                        <Typography variant='h4'>Log in page</Typography>
                    </Box>

                    <Box display="flex"

                         justifyContent="center"
                         component="form"
                         sx={{
                             '& > :not(style)': {m: 1, width: '25ch'},
                         }}

                         onSubmit={handleLogin}
                    >
                        <Stack spacing={2} direction='column'>

                            <TextField
                                id="login"
                                autoFocus
                                label="Login"
                                value={loginValue}
                                onChange={(e) => setLoginValue(e.target.value)}
                                variant="outlined"/>
                            <TextField id="password" label="Password" variant="outlined" type="password"/>
                            <Button
                                type='submit'
                                variant='contained'
                                onClick={handleLogin}
                            >Login</Button>
                        </Stack>
                    </Box>
                </Container>
            </ThemeProvider>
        </div>
    );
};

export default LoginPage;