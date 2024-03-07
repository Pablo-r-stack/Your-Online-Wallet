import { createContext, useContext, useEffect, useState } from "react"
import { API_URL } from "./constants";

const AuthContext = createContext({
    isAuthenticated: "",
    getAccesToken: () => { },
    saveUser: (response) => { },
    /**get refresh token? */
})

export function AuthProvider({ children }) {
    const [user, setUser] = useState({});
    const [accessToken, setAccesstoken] = useState('');
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    useEffect(() => {
        checkAuth();
    }, []);

    function getAccessToken() {
        return accessToken;
    }

    function saveUser(response) {
        saveSessionInfo(response);
    }

    function logOut() {
        setAccesstoken('');
        localStorage.removeItem('token');
        setIsAuthenticated(false);
    }

    function saveSessionInfo(response) {
        const { token, User } = response;
        setAccesstoken(token);
        localStorage.setItem('token', token);
        console.log('Token saved:', token);
        setUser(User);
        console.log('User saved:', User);
        setIsAuthenticated(true);
    }

    async function getUserInfo(accessToken) {
        try {
            const response = axios.get(`${API_URL}/yow`)
            if (response.ok) {
                const json = await response.json();
            }
            return json;
        } catch (error) {
            console.log(error)
            return null;
        }
    }

    async function checkAuth() {
        return isAuthenticated;
    }

    function getAccessToken() {
        const token = localStorage.getItem('token');
        if (token) {
            const { accessToken } = JSON.parse(token);
            return accessToken;
        }
        return null;
    }


    return (
        <AuthContext.Provider value={{ isAuthenticated, getAccessToken, user, saveUser, logOut }}>
            {children}
        </AuthContext.Provider>
    );

}

export const useAuth = () => useContext(AuthContext);