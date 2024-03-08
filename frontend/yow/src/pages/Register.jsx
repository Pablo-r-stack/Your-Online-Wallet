
import React, { useEffect } from "react";
import Button1 from "../components/btn/Button1";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { API_URL } from "../auth/constants";
import { useAuth } from "../auth/AuthProvider";

const Register = () => {
  const navigate = useNavigate();
  const auth = useAuth();
  
  useEffect(() => {
    if (auth.isAuthenticated) {
      console.log('User already registered, redirecting');
      navigate("/dashboard");
    }
  }, []);
  
  {//**Database Country get */}
    const [countries, setCountries] = useState([]);

    useEffect(() => {
      getCountries();
    }, []);

    const getCountries = async () => {
      try {
        const response = await axios.get(`${API_URL}/yow/register`);
          setCountries(response.data);
      } catch (error) {
        console.error("Error fetching countries:", error);
      }
    };
    {/**form person */ }
    const [person, setPerson] = useState({
      name: "",
      lastName: "",
      numberIdentification: "",
      email: "",
      password: "",
      country: { id: "" } // Inicializa country como un objeto con una propiedad id
    });

    const onInputChange = (e) => {
      setPerson({ ...person, [e.target.name]: e.target.value });
    };

    const onCountryChange = (e) => {
      setPerson({ ...person, country: { id: e.target.value } }); // Actualiza solo la propiedad id del país seleccionado
    };
    

    const onSubmit = async (e) => {
      e.preventDefault();
      try {
        const response = await axios.post(`http://localhost:8080/yow/save-register`, person);
          console.log('Register Succesfull');
          alert('Registro exitoso! Por favor inicia sesión', 'Éxito');
          navigate("/login");
      } catch (error) {
        console.log(error);
      }
    }
    return (
      <div className='container mx-auto flex flex-col items-center justify-center lg:flex-row my-32'>
        <div className="lg:w-3/5 md:w-4/5 w-full">
          <form className="bg-zinc-950 p-6 rounded-lg shadow-lg grid grid-cols-2">
            <h1 className="col-span-2 text-3xl mb-6 text-white font-bold font-sans">
              Regístrese
            </h1>
            <div className="m-1 col-span-1">
              <label
                className="text-white font-semibold block my-3 text-md"
                htmlFor="personname"
              >
                Nombre
              </label>
              <input
                className="w-full bg-gray-100 px-4 py-2 rounded-lg"
                type="text"
                name="name"
                value={person.name}
                onChange={(e) => onInputChange(e)}
                id="personname"
                placeholder="Ingrese su nombre"
              />
            </div>
            <div className="m-1 col-span-1">
              <label
                className="text-white font-semibold block my-3 text-md"
                htmlFor="lastName"
              >
                Apellido
              </label>
              <input
                className="w-full bg-gray-100 px-4 py-2 rounded-lg"
                type="text"
                name="lastName"
                value={person.lastName}
                onChange={(e) => onInputChange(e)}
                id="lastName"
                placeholder="Ingrese su apellido"
              />
            </div>
            <div className="m-1 col-span-2">
              <label
                className="text-white font-semibold block my-3 text-md"
                htmlFor="email"
              >
                Mail
              </label>
              <input
                className="w-full bg-gray-100 px-4 py-2 rounded-lg "
                type="text"
                name="email"
                value={person.email}
                onChange={(e) => onInputChange(e)}
                id="email"
                placeholder="email@email.com"
              />
            </div>
            <div className="m-1 col-span-1">
              <label
                className="text-white font-semibold block my-3 text-md"
                htmlFor="password"
              >
                Ingrese su contraseña
              </label>
              <input
                className="w-full bg-gray-100 px-4 py-2 rounded-lg"
                type="password"
                name="password"
                value={person.password}
                onChange={(e) => onInputChange(e)}
                id="password"
                placeholder="Contraseña"
              />
            </div>
            <div className="m-1 col-span-1">
              <label
                className="text-white font-semibold block my-3 text-md"
                htmlFor="confirm"
              >
                Repita la contraseña
              </label>
              <input
                className="w-full bg-gray-100 px-4 py-2 rounded-lg"
                type="password"
                name="confirm"
                id="confirm"
                placeholder="Contraseña"
              />
            </div>
            <div className="m-1 col-span-1">
              <label
                className="text-white font-semibold block my-3 text-md"
                htmlFor="confirm"
              >ingrese su número de documento
              </label>
              <input
                className="w-full bg-gray-100 px-4 py-2 rounded-lg"
                type="text"
                name="numberIdentification"
                value={person.numberIdentification}
                onChange={(e) => onInputChange(e)}
                id="document"
                placeholder="Ej: 35998774"
              />
            </div>

            <div className="m-1 col-span-1">
              <label htmlFor="countries" className="text-white font-semibold block my-3 text-md">De qué pais eres?</label>
              <select
                id="countries"
                className="w-full bg-gray-100 px-4 py-2 rounded-lg"
                value={person.country.id} // Establece el valor seleccionado del select
                onChange={(e) => onCountryChange(e)} // Maneja el cambio en el select
              >
                <option value="">Selecciona tu País</option>
                {countries.map((country) => (
                  <option key={country.id} value={country.id}>
                    {country.country}
                  </option>
                ))}
              </select>
            </div>
            <div className="col-span-2 flex justify-center">
              <Button1 text='Registrarse' onClick={onSubmit} />
            </div>

          </form>
        </div>
      </div>
    );
  };
}
export default Register;

