import React from 'react';
import {Container, Stack, ThemeProvider, Typography} from "@mui/material";
import {marsTheme} from "../App";

const HomePage = () => {
    return (
        <div>
            <ThemeProvider theme={marsTheme}>
                <Container maxWidth='lg'>

                    <Stack
                        direction="row"
                        justifyContent="center"
                        alignItems="center"
                    >
                        <Typography variant='h2'>
                            Мэйн Страница
                        </Typography>
                    </Stack>
                </Container>
                <Container fixed>
                    <Stack sx={{
                        minHeight: 700,
                        alignItems: 'center'

                    }}>

                        <div className='circle-container'>
                            <a href='#' className='center'>Top Rating</a>
                            <a href='#' className='deg0'>Crappy category 1</a>
                            <a href='#' className='deg45'>Crappy category 2</a>
                            <a href='#' className='deg135'>Crappy category 3</a>
                            <a href='#' className='deg180'>Crappy category 4</a>
                            <a href='#' className='deg225'>Crappy category 5</a>
                            <a href='#' className='deg315'>Crappy category 6</a>
                        </div>
                    </Stack>
                </Container>
            </ThemeProvider>
        </div>
    );
};

export default HomePage;