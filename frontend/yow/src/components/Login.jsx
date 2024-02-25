import "./button/Button";
import Button from "./button/Button";

const Form = () => {

  const handleClick = () => {
    console.log("Boton Click")
  }

  return (
    <>
      <div class="flex flex-col items-center justify-center relative max-w-2xl bg-black rounded-xl">
        <div class="flex flex-col shadow-md px-4 sm:px-6 md:px-8 lg:px-10 py-8 rounded w-full max-w-md justify-center">
          <div class="w-full py-7 px-7">
            <div class="flex flex-col items-center">
              <h1 className="text-3xl text-white">Iniciar Sesión</h1>
            </div>
            <form action="login">
              <div class="relative p-0 mt-8 w-full h-12">
                <input
                  className="p-3 absolute w-full h-full text-base border-2 rounded-xl border-black border-solid"
                  type="email"
                  id="email"
                  name="email"
                  placeholder="Ingrese su email"
                  minlength="10"
                  maxlength="50"
                  required
                />
              </div>
              <div class="relative p-0 mt-8 w-full h-12">
                <input
                  className="p-3 absolute w-full h-full text-base border-2 rounded-xl border-black border-solid"
                  type="password"
                  id="password"
                  name="password"
                  placeholder="Ingrese su contraseña"
                  minlength="5"
                  maxlength="30"
                  required
                />
              </div>
              <div>
                <Button className='handleClick'/>
                </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default Form;
