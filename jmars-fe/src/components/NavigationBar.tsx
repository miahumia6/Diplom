import React, {useState} from 'react';
import {
    AppBar,
    Button,
    Container,
    IconButton,
    Menu,
    MenuItem,
    Stack,
    ThemeProvider,
    Toolbar,
    Typography
} from "@mui/material";
import {KeyboardArrowDown, ShieldMoon} from "@mui/icons-material";
import {Link} from "react-router-dom";
import {useAppDispatch, useAppSelector} from "../app/hooks";
import {logout, selectAuth, selectRole} from "../store/loginSlice";
import {marsTheme} from "../App";
import AddIcon from '@mui/icons-material/Add';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';

const NavigationBar = () => {
    const auth = useAppSelector(selectAuth);
    const role = useAppSelector(selectRole);
    const dispatch = useAppDispatch();
    const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null)
    const open = Boolean(anchorEl);
    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorEl(event.currentTarget);
    }

    console.log("ROle:" + role)

    const handleClose = () => {
        setAnchorEl(null)
    }

    const handleLogout = () => {
        handleClose();
        dispatch(logout())
    }

    return (
        <div>
            <ThemeProvider theme={marsTheme}>
                <AppBar
                    position='static'
                    color="primary"
                >
                    <Container>
                        <Toolbar>
                            <IconButton
                                size='large'
                                edge='start'
                                color='inherit'
                                aria-label='logo'
                            >
                                <ShieldMoon/>
                            </IconButton>
                            <Typography variant='h6' component='div' sx={{flexGrow: 1}}>
                                JMars
                            </Typography>
                            <Stack
                                direction='row'
                                spacing={2}
                            >


                                {auth && <>
                                    <Button color='inherit' component={Link} to={'/'}> Home</Button>

                                    {
                                        role === 'admin'
                                            ? <Button color='inherit' component={Link} to={'/edit'}>Admin panel</Button>
                                            : <Button
                                                endIcon={<AddCircleOutlineIcon/>}
                                                color='inherit'
                                                component={Link}
                                                to={'/answer'}
                                            > Submit response</Button>
                                    }


                                    <Button color='inherit' component={Link} to={'/about'}> About</Button>
                                    <Button color='inherit'
                                            id='resources-button'
                                            onClick={handleClick}
                                            aria-control={open ? 'resources-menu' : undefined}
                                            aria-haspopup='true'
                                            aria-expanded={open ? 'true' : undefined}
                                            endIcon={<KeyboardArrowDown/>}
                                    >Profile</Button>
                                </>

                                }
                            </Stack>

                            <Menu id='resources-menu' anchorEl={anchorEl} open={open}
                                  MenuListProps={{'aria-labelledby': 'resources-button'}}
                                  onClose={handleClose}
                            >
                                <MenuItem onClick={handleClose}>Settings</MenuItem>
                                <MenuItem onClick={handleLogout}>Log out</MenuItem>
                            </Menu>
                        </Toolbar>
                    </Container>
                </AppBar>
            </ThemeProvider>
        </div>
    );
};

export default NavigationBar;