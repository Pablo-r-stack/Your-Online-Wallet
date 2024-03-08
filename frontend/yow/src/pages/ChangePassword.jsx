import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import Button1 from "../components/btn/Button1";
import axios from "axios";
import { API_URL } from "../auth/constants";
import { useAuth } from "../auth/AuthProvider";

const ChangePassword = () => {
  const navigate = useNavigate();
  const auth = useAuth();

  const [password, setPassword] = useState('');
  const [password2, setPassword2] = useState('');
  
  const onInputChange = (e) => {
    const { name, value } = e.target;
    if (name === 'password') {
      setPassword(value);
    } else if (name === 'password2') {
      setPassword2(value);
    }
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    if (password !== password2) {
      alert('Las contraseñas no coinciden, intenta de nuevo', 'Error');
      document.getElementById('password').focus();
    } else {
      try {
        const token = localStorage.getItem('token');
        const username = auth.user.username;
        const config = {
          headers: { Authorization: `Bearer ${token}` }
        };
        console.log('Solicitando autorización al servidor');
        const response = await axios.post(`${API_URL}/yow/change-password`, null, {
          ...config,
          params: { numDocument: username, password: password } // Pasar el nombre de usuario y contraseña como parámetros en la URL
        });
        if (response.status === 200) {
          console.log('Contraseña cambiada exitosamente');
          alert('Contraseña cambiada exitosamente!', 'Éxito');
          navigate('/dashboard');
        } else {
          console.log('Hubo un problema al cambiar la contraseña');
          // Aquí puedes manejar el caso en el que el cambio de contraseña no fue exitoso
        }
      } catch (error) {
        console.error('Ocurrió un error:', error);
        // Aquí puedes manejar errores de red u otros tipos de errores
      }
    }
  };

  return (
    <div className="container mx-auto flex flex-col items-center justify-center lg:flex-row lg:h-5/6 my-32 max-w-2xl bg-black rounded-xl">
      <div className="flex flex-col shadow-md px-4 sm:px-6 md:px-8 lg:px-10 py-8 rounded w-full max-w-md justify-center">
        <div className="w-full py-7 px-7">
          <div className="flex flex-col items-center">
            <h1 className="text-3xl text-white">Cambiar contraseña</h1>
          </div>
          <form onSubmit={onSubmit}>
            <div className="relative p-0 mt-8 w-full h-12">
              <input
                className="p-3 absolute w-full h-full text-base border-2 rounded-xl border-black border-solid"
                type="password"
                id="password"
                name="password"
                value={password}
                placeholder="Ingrese su nueva contraseña"
                required
                onChange={onInputChange}
              />
            </div>
            <div className="relative p-0 mt-8 w-full h-12">
              <input
                className="p-3 absolute w-full h-full text-base border-2 rounded-xl border-black border-solid"
                type="password"
                id="password2"
                name="password2"
                value={password2}
                placeholder="Repita su nueva contraseña"
                required
                onChange={onInputChange}
              />
            </div>
            <div>
              <Button1 text='Cambiar Contraseña' type="submit" />
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default ChangePassword;
