import React, { useState } from 'react';

const ChangePasswordModal = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [currentPassword, setCurrentPassword] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [confirmNewPassword, setConfirmNewPassword] = useState('');

  const openModal = () => {
    setIsOpen(true);
  };

  const closeModal = () => {
    setIsOpen(false);
    setCurrentPassword('');
    setNewPassword('');
    setConfirmNewPassword('');
  };

  const handleChangePassword = () => {
    console.log('Cambiando contraseña...');
    closeModal();
  };

  return (
    <div className='lg:flex-row lg:h-5/6 my-32 max-w-2xl'>
      {isOpen && (
        <div className="fixed inset-0">
          <div className="flex items-end justify-center min-h-screen pt-4 px-4 pb-20 text-center sm:block sm:p-0">
            <div className="fixed inset-0 transition-opacity" aria-hidden="true">
              <div className="absolute inset-0 bg-gray-500 opacity-75"></div>
            </div>

            <div className="inline-block align-bottom rounded-lg text-left overflow-hidden shadow-xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full">
              <div className="bg-black w-full sm:p-6 sm:pb-4 flex justify-center">
                <div className="sm:flex sm:items-start">
                  <div className="text-center sm:mt-0 sm:ml-4 sm:text-left">
                    <h1 className="text-2xl leading-6 text-white mb-3 text-center">Cambiar Contraseña</h1>

                    <div className="w-80">
                      <div className="mb-4">
                        <label htmlFor="currentPassword" className="block text-sm font-medium text-white">Contraseña Actual</label>
                        <input type="password" id="currentPassword" name="currentPassword" value={currentPassword} onChange={(e) => setCurrentPassword(e.target.value)} autoComplete="current-password" className="mt-1 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md py-2 px-1" />
                      </div>
                      <div className="mb-4">
                        <label htmlFor="newPassword" className="block text-sm font-medium text-white">Nueva Contraseña</label>
                        <input type="password" id="newPassword" name="newPassword" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} autoComplete="new-password" className="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md py-2 px-1" />
                      </div>
                      <div className="mb-4">
                        <label htmlFor="confirmNewPassword" className="block text-sm font-medium text-white">Confirmar Nueva Contraseña</label>
                        <input type="password" id="confirmNewPassword" name="confirmNewPassword" value={confirmNewPassword} onChange={(e) => setConfirmNewPassword(e.target.value)} autoComplete="new-password" className="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md py-2 px-1" />
                      </div>
                    </div>
                    <div className="bg-black justify-center sm:px-6 sm:flex sm:flex-row-reverse">

                      <button onClick={handleChangePassword} type="button" className="w-full inline-flex justify-center rounded-md border border-transparent shadow-sm px-4 py-2 bg-white text-base font-medium text-black hover:bg-black hover: hover:text-white hover:border-white hover:border-solid hover:border-2  sm:w-auto sm:text-sm">
                        Cambiar Contraseña
                      </button>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
      )}
      <button onClick={openModal} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Cambiar Contraseña
      </button>
    </div>
  );
};

export default ChangePasswordModal;

