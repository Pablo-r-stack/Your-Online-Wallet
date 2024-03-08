import React, { useState } from 'react';
import Button3 from './btn/Button3';
import { useAuth } from '../auth/AuthProvider';
import { useWallet } from '../auth/WalletProvider';

const ModalPagos = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [monto, setMonto] = useState('');
  const [nombreDeLaEmpresa, setNombre] = useState('');
  // const [cuenta, setCuenta] = useState('');
  const [accionRealizada, setAccionRealizada] = useState(false);
  const [cancelado, setCancelado] = useState(false);
  const auth = useAuth();
  const wallet = useWallet();

  const toggleModal = () => {
    setIsOpen(!isOpen);
    setAccionRealizada(false);
    setCancelado(false);
  };

  const handleAceptar = () => {
    const {balance} = wallet.getWallet();
    console.log(balance);
    if (balance < monto) {
      alert('Tu saldo es insuficiente, por favor recarga e intentalo nuevamente');
      setMonto('');
      setNombre('');
      return; // Detener la ejecución si el saldo es insuficiente
    }
      wallet.servicePay(monto, auth.user.username);
      setMonto('');
      setNombre('');
      setAccionRealizada(true);
      alert('Pago realizado!');
      toggleModal();
    };

  const handleCancelar = () => {
    setTimeout(() => {
      toggleModal();
      setCancelado(true);
      console.log("Pago cancelado");
    }, 2000);
  };

  const handleMontoChange = (event) => {
    const value = event.target.value
    setMonto(value);
  };

  return (
    <div className='lg:flex-row lg:h-5/6 my-32 max-w-2xl'>
      {isOpen && (
        <div className="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity">
          <div className="fixed inset-0 z-10 flex items-center justify-center">
            <div className="absolute inset-0 bg-gray-500 opacity-75"></div>
            <div className="relative bg-white rounded-lg px-4 pt-4 pb-4 overflow-hidden shadow-xl transform transition-all sm:max-w-lg sm:w-full">
              <div className="absolute top-0 right-0 pt-4 pr-4">
                <button
                  onClick={toggleModal}
                  className="text-gray-400 hover:text-gray-500 focus:outline-none focus:text-gray-500 transition ease-in-out duration-150"
                >
                  <span className="sr-only">Cerrar</span>
                  <svg className="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12" />
                  </svg>
                </button>
              </div>
              <div>
                <div className="sm:flex sm:items-center justify-center">
                  <div className="mt-3 text-center sm:mt-0 sm:text-center">
                    <h3 className="text-xl leading-6 font-bold text-gray-900 text-center" id="modal-title">
                      Pago a realizar
                    </h3>
                    <div className="mt-2 flex flex-col justify-center items-center">
                      <p className="text-sm text-black">
                        Complete los datos para realizar su pago!
                      </p>
                      <input
                        type="text"
                        placeholder="Monto a pagar"
                        value={monto}
                        onChange={handleMontoChange}
                        className="block mt-5 h-8 w-full border-black rounded-md shadow-sm border-2 border-solid sm:text-sm p-1"
                      />
                      {/* <input
                        type="text"
                        placeholder="(tu documento)"
                        value={cuenta}
                        onChange={(e) => setCuenta(e.target.value)}
                        className="block mt-2 h-8 w-full border-black rounded-md shadow-sm border-2 border-solid sm:text-sm uppercase p-1"
                      /> */}
                      <input
                        type="text"
                        placeholder="Nombre de la empresa"
                        value={nombreDeLaEmpresa}
                        onChange={(e) => setNombre(e.target.value)}
                        className="block mt-2 h-8 w-full border-black rounded-md shadow-sm border-2 border-solid sm:text-sm uppercase p-1"
                      />
                    </div>
                  </div>
                </div>
              </div>
              <div className="bg-gray-50 flex justify-center px-4 py-3 sm:px-6 sm:flex sm:flex-row-reverse">
                {!accionRealizada ? (
                  <>
                    <button
                      onClick={handleAceptar}
                      className="w-full inline-flex justify-center rounded-md border border-transparent shadow-sm px-4 py-2 bg-black text-base font-medium text-white hover:bg-green-600 sm:mr-8 sm:w-auto sm:text-sm"
                    >
                      Aceptar
                    </button>
                    <button
                      onClick={handleCancelar}
                      className="w-full inline-flex justify-center rounded-md border border-gray-300 shadow-sm px-4 py-2 bg-black text-base font-medium text-white hover:bg-red-600  focus:ring-indigo-500 sm:mt-0 sm:ml-8 sm:w-auto sm:text-sm"
                    >
                      Cancelar
                    </button>
                  </>
                ) : (
                  cancelado ? (
                    <div className="flex items-center justify-center text-red-500">
                      <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 13l4 4L19 7" />
                      </svg>
                      <span>¡Pago Cancelado!</span>
                    </div>
                  ) : (
                    <div className="flex items-center justify-center text-green-500">
                      <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 13l4 4L19 7" />
                      </svg>
                      <span>¡Pago Realizado!</span>
                    </div>
                  )
                )}
              </div>
            </div>
          </div>
        </div>
      )}
      <Button3 text='Pagar Servicios' onClick={toggleModal} />
    </div>
  );
};

export default ModalPagos;
