import React, { useState } from "react";

const Modal = () => {
  const [showModal, setShowModal] = useState(false);
  return (
    <>
      <button
        className=" text-black
      font-bold px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1"
        type="button"
        onClick={() => setShowModal(true)}
      >
        Abrir modal
      </button>
      {showModal ? (
        <>
          <div className="flex justify-center items-center  overflow-x-hidden overflow-y-auto fixed inset-0  outline-none focus:outline-none lg:w-3/5 md:w-4/5 w-full">
            <div className="relative w-2/3 my-6 mx-auto max-w-3xl">
              <div className="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-black outline-none focus:outline-none">
                <div className="flex items-center justify-center p-3">
                  <h3 className="text-white text-3xl flex justify-center font=semibold">Ingrese tarjeta</h3>
                  <button
                    className="bg-transparent border-0 text-black float-right"
                    onClick={() => setShowModal(false)}
                  >
                  </button>
                </div>
                <div className="relative p-2 flex-auto">
                  <form className="bg-black shadow-md rounded px-8 w-full grid grid-cols-2">
                    <div className="col-span-1 mr-2">
                      <label className="block text-white text-sm font-bold mb-3">
                        Número de tarjeta
                      </label>
                      <input className="shadow appearance-none border rounded w-full py-2 px-1 text-black mb-3 required:" placeholder="4042 4042 4042 4042" />
                    </div>
                    <div className="col-span-1 ml-2">
                      <label className="block text-white text-sm font-bold mb-3">
                        Código de seguridad
                      </label>
                      <input className="shadow appearance-none border rounded w-full py-2 px-1 text-black mb-3" placeholder="CCV"/>
                    </div>
                    <div className="col-span-2">
                      <label className="block text-white text-sm font-bold mb-3">
                        Nombre y Apellido
                      </label>
                      <input className="shadow appearance-none border rounded w-full py-2 px-1 text-black mb-3" />
                    </div>
                  </form>
                </div>
                <div className="flex items-center justify-center pb-2 border-blueGray-200 rounded-b">
                  <button
                    className=" text-black bg-white font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1 hover:bg-black hover:text-white rounded-md hover:border-white hover:border-solid hover:border-2"
                    type="button"
                    onClick={() => setShowModal(false)}
                  >
                    Aceptar
                  </button>
                </div>
              </div>
            </div>
          </div>
        </>
      ) : null}
    </>
  );
};

export default Modal;