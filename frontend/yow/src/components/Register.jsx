
import Button from "./Button";

const Register = () => {
  return (
    <div className="h-screen w-10/12 bg-white flex justify-center items-center">
      <div className="lg:w-3/5 md:w-4/5 w-full">
        <form className="bg-gray-900 p-6 rounded-lg shadow-lg grid grid-cols-2">
          <h1 className="col-span-2 text-3xl mb-6 text-white font-bold font-sans">
            Regístrese
          </h1>
          <div className="m-1 col-span-1">
            <label
              className="text-white font-semibold block my-3 text-md"
              for="username"
            >
              Nombre
            </label>
            <input
              className="w-full bg-gray-100 px-4 py-2 rounded-lg"
              type="text"
              name="username"
              id="username"
              placeholder="Ingrese su nombre"
            />
          </div>
          <div className="m-1 col-span-1">
            <label
              className="text-white font-semibold block my-3 text-md"
              for="lastName"
            >
              Apellido
            </label>
            <input
              className="w-full bg-gray-100 px-4 py-2 rounded-lg"
              type="text"
              name="lastName"
              id="lastName"
              placeholder="Ingrese su apellido"
            />
          </div>
          <div className="m-1 col-span-2">
            <label
              className="text-white font-semibold block my-3 text-md"
              for="email"
            >
              Mail
            </label>
            <input
              className="w-full bg-gray-100 px-4 py-2 rounded-lg "
              type="text"
              name="email"
              id="email"
              placeholder="email@email.com"
            />
          </div>
          <div className="m-1 col-span-1">
            <label
              className="text-white font-semibold block my-3 text-md"
              for="password"
            >
              Ingrese su contraseña
            </label>
            <input
              className="w-full bg-gray-100 px-4 py-2 rounded-lg"
              type="text"
              name="password"
              id="password"
              placeholder="Contraseña"
            />
          </div>
          <div className="m-1 col-span-1">
            <label
              className="text-white font-semibold block my-3 text-md"
              for="confirm"
            >
              Repita la contraseña
            </label>
            <input
              className="w-full bg-gray-100 px-4 py-2 rounded-lg"
              type="text"
              name="confirm"
              id="confirm"
              placeholder="Contraseña"
            />
          </div>
          <div className="m-1 col-span-1">
            <label
              className="text-white font-semibold block my-3 text-md"
              for="confirm"
            >ingrese su número de documento
            </label>
            <input
              className="w-full bg-gray-100 px-4 py-2 rounded-lg"
              type="text"
              name="document"
              id="document"
              placeholder="Ej: 35998774"
            />
          </div>

          <div class="m-1 col-span-1">

	          <label for="countries" className="text-white font-semibold block my-3 text-md">Selecciona una opción</label>
            <select id="countries" className="w-full bg-gray-100 px-4 py-2 rounded-lg">
              <option selected>De qué pais eres?</option>
              <option value="AR">Argentina</option>
              <option value="US">Estados Unidos</option>
              <option value="FR">Francia</option>
              <option value="UY">Uruguay</option>
            </select>
          </div>
          <div className="col-span-2 flex justify-center">
            <Button/>
          </div>
          
        </form>
      </div>
    </div>
  );
};

export default Register;


