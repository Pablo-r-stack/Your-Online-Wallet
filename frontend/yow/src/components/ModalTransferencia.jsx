import React, { useState } from 'react';
import Button3 from './btn/Button3';
import { useAuth } from '../auth/AuthProvider';
import { useWallet } from '../auth/WalletProvider';

const ModalTransferencia = () => {
  const auth = useAuth();
  const wallet = useWallet();
  const [isOpen, setIsOpen] = useState(false);
  const [userReciever, setUserReciever] = useState({
    numberDocument: '',
    mount: ''
  });

  const [accionRealizada, setAccionRealizada] = useState(false);

  const toggleModal = () => {
    setIsOpen(!isOpen);
    setAccionRealizada(false);
  };

  const handleAceptar = () => {
    // Aquí puedes realizar las acciones necesarias con el monto y la cuenta
    const {balance} = wallet.getWallet();
    console.log(balance);
    if (balance < userReciever.mount) {
      alert('Tu saldo es insuficiente, por favor recarga e intentalo nuevamente');
      setUserReciever({
        numberDocument: '',
        mount: ''
      });
      return; // Detener la ejecución si el saldo es insuficiente
    }
    const username = auth.user.username;
    console.log(username);
    wallet.mountTransfer(username, userReciever);
    setUserReciever({
      numberDocument: '',
      mount: ''
    });
    alert('Tu transferencia fue enviada!');
    toggleModal();
    setAccionRealizada(true);
  };

  const onInputChange = (e) => {
    setUserReciever({ ...userReciever, [e.target.name]: e.target.value });
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
                    <h3 className="text-lg leading-6 font-bold text-gray-900 text-center" id="modal-title">
                      Transferencia
                    </h3>
                    <div className="mt-2 flex flex-col justify-center items-center">
                      <p className="text-sm text-black">
                        Para realizar una transferencia complete los siguientes datos!
                      </p>
                      <input
                        type="text"
                        placeholder="Monto a transferir"
                        value={userReciever.mount}
                        onChange={(e) => onInputChange(e, 'mount')}
                        name="mount"
                        className="block mt-5 h-8 w-1/2 border-black   rounded-md shadow-sm border-2 border-solid sm:text-sm p-1"
                      />
                      <input
                        type="text"
                        placeholder="Cuenta o alias"
                        value={userReciever.numberDocument}
                        onChange={(e) => onInputChange(e, 'numberDocument')}
                        name="numberDocument"
                        className="block mt-2 h-8 w-1/2 border-black rounded-md shadow-sm border-2 border-solid sm:text-sm uppercase p-1"
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
                      className="w-full inline-flex justify-center rounded-md border border-transparent shadow-sm px-4 py-2 bg-black text-base font-medium text-white hover:bg-green-600 sm:ml-2 sm:w-auto sm:text-sm"
                    >
                      Aceptar
                    </button>
                    <button
                      onClick={toggleModal}
                      className="w-full inline-flex justify-center rounded-md border border-gray-300 shadow-sm px-4 py-2 bg-black text-base font-medium text-white hover:bg-red-600  focus:ring-indigo-500 sm:mt-0 sm:mr-2 sm:w-auto sm:text-sm"
                    >
                      Cancelar
                    </button>
                  </>
                ) : (
                  <div className="flex items-center justify-center text-green-500">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 13l4 4L19 7" />
                    </svg>
                    <span>¡Realizado!</span>
                  </div>
                )}
              </div>
            </div>
          </div>
        </div>
      )}
      <Button3 text='Transferir' onClick={toggleModal} />
    </div>


  )
}

export default ModalTransferencia;