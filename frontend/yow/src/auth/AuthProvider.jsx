import { createContext, useContext, useEffect, useState } from "react"
import { API_URL } from "./constants";

const AuthContext = createContext({
    isAuthenticated:"",
    getAccesToken: () => { },
    saveUser: (userData) => { },
    /**get refresh token? */
})

export function AuthProvider({ children }) {
    const [user, setUser] = useState();
    const [accessToken, setAccesstoken] = useState('');
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    useEffect(() => {
        checkAuth();
    }, []);

    function getAccessToken() {
        return accessToken;
    }

    function saveUser(userData) {
        console.log(`${userData.JSON} from auth provider`);
        saveSessionInfo(userData.User, userData.token);
    }

    function saveSessionInfo(userInfo, accessToken) {
        setAccesstoken(accessToken);
        localStorage.setItem('token', accessToken);
        console.log('token stored');
        setUser(userInfo);
        console.log('user stored');
        setIsAuthenticated(true);
    }

    async function getUserInfo(accessToken){
        try{
            const response = axios.get(`${API_URL}/yow`)
            if(response.ok){
                const json = await response.json();
            }
            return json;
        }catch(error){
            console.log(error)
            return null;
        }
    }

    async function checkAuth(){
        return isAuthenticated;
    }

    function getAccessToken(){
        const token = localStorage.getItem('token');
        if(token){
            const {accessToken} = JSON.parse(token);
            return accessToken;
        }
        return null;
    }


    return (
        <AuthContext.Provider value={{ isAuthenticated, getAccessToken, saveUser }}>
            {children}
        </AuthContext.Provider>
    );

}

export const useAuth = () => useContext(AuthContext);