import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import Button1 from "../components/btn/Button1";
import axios from "axios";
import { API_URL } from "../auth/constants";
import { useAuth } from "../auth/AuthProvider";


const Form = () => {
  const navigate = useNavigate();

  const auth = useAuth();

  useEffect(() => {
    if (auth.isAuthenticated) {
      console.log('User already registered, redirecting');
      navigate("/dashboard");
    }
  }, []);

  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log(user);
      const response = await axios.post(`${API_URL}/yow/login`, user);
      if(response){
        console.log('Login succesful');
        auth.saveUser(response.data);
        navigate("/dashboard");
      }
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      <div className="container mx-auto flex flex-col items-center justify-center lg:flex-row lg:h-5/6 my-32 max-w-2xl bg-black rounded-xl">
        <div className="flex flex-col shadow-md px-4 sm:px-6 md:px-8 lg:px-10 py-8 rounded w-full max-w-md justify-center">
          <div className="w-full py-7 px-7">
            <div className="flex flex-col items-center">
              <h1 className="text-3xl text-white">Iniciar Sesión</h1>
            </div>
            <form>
              <div className="relative p-0 mt-8 w-full h-12">
                <input
                  className="p-3 absolute w-full h-full text-base border-2 rounded-xl border-black border-solid"
                  type="number"
                  id="username"
                  name="username"
                  value={user.username}
                  placeholder="Ingrese su username"
                  required
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <div className="relative p-0 mt-8 w-full h-12">
                <input
                  className="p-3 absolute w-full h-full text-base border-2 rounded-xl border-black border-solid"
                  type="password"
                  id="password"
                  name="password"
                  value={user.password}
                  placeholder="Ingrese su contraseña"
                  required
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <div>
                <Button1 text='Iniciar Sesión' onClick={onSubmit} />
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default Form;
