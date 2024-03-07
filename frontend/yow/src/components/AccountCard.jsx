import React, { useState } from 'react'

import Button3 from './btn/Button3'
import EyeToggle from './btn/EyeToggle'
import ModalTransferencia from './ModalTransferencia';
import ModalPagos from './ModalPagos';
import AddFundsModal from './AddFundsModal';

export default function AccountCard({balance}) {

    return (
        <div>
            <section className="flex flex-col group rounded-lg [&_summary::-webkit-section-marker]:hidden border-2 space-y-8 p-10 bg-gray-100 border-zinc-900 shadow-md shadow-zinc-500 transition-all">
                <div className='flex flex-col items-center justify-center space-y-8'>
                    <h2 className='font-bold text-4xl'>Tu saldo YOW es de:</h2>
                    <div >
                    <EyeToggle defaultText={`$ ${balance}`}/>
                    </div>
                </div>
                <div className='flex items-center justify-center pt-8 space-x-4 h-36'>
                    <AddFundsModal />
                    <ModalTransferencia />
                    <ModalPagos />
                </div>

            </section >
        </div >




    )
}
