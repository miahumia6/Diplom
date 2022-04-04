import React from 'react';
import {Box, Button, Container, Stack, TextField, ThemeProvider, Typography} from "@mui/material";
import {marsTheme} from "../App";

const AnswerPage = () => {
    return (
        <div>
            <ThemeProvider theme={marsTheme}>
                <Container maxWidth='lg'>

                    <Stack
                        direction="row"
                        justifyContent="center"
                        alignItems="center"
                    >
                        <Typography variant='h5'>
                            Please answer following questioner:
                        </Typography>
                    </Stack>

                    <Box display="flex"
                         justifyContent="center"
                         component="form"
                         sx={{
                             '& > :not(style)': {m: 1, width: '25ch'},
                         }}
                    >
                        <Stack spacing={2} direction='column'>

                            <TextField
                                id="firstName"
                                label="First Name"
                                variant="outlined"
                            />
                            <TextField
                                id="lastName"
                                label="Last Name"
                                variant="outlined"
                            />

                            <Button
                                type='submit'
                                variant='contained'
                            >
                                Submit answer
                            </Button>
                        </Stack>
                    </Box>
                </Container>

            </ThemeProvider>
        </div>
    );
};

export default AnswerPage;