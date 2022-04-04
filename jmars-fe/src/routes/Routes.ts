import HomePage from "../pages/HomePage";
import AboutPage from "../pages/AboutPage";
import LoginPage from "../pages/LoginPage";
import AnswerPage from "../pages/AnswerPage";
import AdminPage from "../pages/AdminPage";

export const privateRoutes = [
    {path: '/', component: HomePage, exact: true},
    {path: '/about', component: AboutPage, exact: true},
    {path: '/login', component: LoginPage, exact: true},
    {path: '/answer', component: AnswerPage, exact: true},
    {path: '/edit', component: AdminPage, exact: true},
]

export const publicRoutes = [
    // {path: '/', component: HomePage, exact: true},
    {path: '/login', component: LoginPage, exact: true},
]