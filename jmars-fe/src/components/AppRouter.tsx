import React from 'react';
import {Navigate, Route, Routes} from "react-router-dom";
import {privateRoutes, publicRoutes} from "../routes/Routes";
import {useAppSelector} from "../app/hooks";
import {selectAuth} from "../store/loginSlice";


const AppRouter = () => {
    const auth = useAppSelector(selectAuth);

    console.log("APP ROUTER:" + auth)

    return (
        <div>
            {
                auth
                    ?
                    <Routes>
                        {privateRoutes.map(route =>
                            <Route
                                path={route.path}
                                element={<route.component/>}
                                key={route.path}
                            />
                        )}
                        <Route
                            path="*"
                            element={<Navigate to="/" replace/>}
                        />
                    </Routes>
                    :
                    <Routes>
                        {publicRoutes.map(route =>
                            <Route
                                path={route.path}
                                element={<route.component/>}
                                key={route.path}
                            />
                        )}
                        <Route path="*"
                               element={<Navigate to="/login" replace/>}
                        />
                    </Routes>
            }
        </div>

    );
};

export default AppRouter;