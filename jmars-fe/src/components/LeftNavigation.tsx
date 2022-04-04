import React from 'react';
import {Box, Typography} from "@mui/material";

const LeftNavigation = () => {
    return (
        <Box
            sx={{
                width: 100,
                height: 300,
                backgroundColor: 'primary.dark',
                '&:hover': {
                    backgroundColor: 'primary.main',
                    opacity: [0.9, 0.8, 0.7],
                },
            }}
        >
            <Typography variant='h6' component='div'>
                Side panel
            </Typography>
        </Box>
    );
};

export default LeftNavigation;