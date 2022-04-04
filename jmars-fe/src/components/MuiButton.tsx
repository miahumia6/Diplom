import React from 'react';
import {Button, ButtonGroup, IconButton, Stack} from "@mui/material";
import SendIcon from "@mui/icons-material/Send"

const MuiButton = () => {
    return (
        <Stack spacing={4}>
            <Stack spacing={2} direction='row'>
                <Button variant='text' href='https://google.com'> Text</Button>
                <Button variant='contained'> Contained</Button>
                <Button variant='outlined'> Outlined</Button>
            </Stack>
            <Stack spacing={2} direction='row'>
                <Button variant='contained' color='primary'> Primary</Button>
                <Button variant='contained' color='secondary'> Secondary</Button>
                <Button variant='outlined' color='error'> Error</Button>
            </Stack>
            <Stack spacing={2} direction='row'>
                <Button
                    variant='contained'
                    startIcon={<SendIcon/>}
                >Send</Button>
                <Button
                    variant='contained'
                    endIcon={<SendIcon/>}
                >Send</Button>
                <IconButton>
                    <SendIcon/>
                </IconButton>
            </Stack>

            <Stack direction='row'>
                <ButtonGroup variant='outlined'>
                    <Button>Left</Button>
                    <Button>Center</Button>
                    <Button>Right</Button>
                </ButtonGroup>
            </Stack>
        </Stack>
    );
};

export default MuiButton;