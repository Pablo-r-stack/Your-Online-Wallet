import React from 'react'

import Button3 from './btn/Button3'
import EyeToggle from './btn/EyeToggle'

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
                <div className='flex items-center justify-center space-x-4'>
                    <Button3 text='Ingresar Dinero' />
                    <Button3 text='Transferir' />
                    <Button3 text='Pagar Servicios' />
                </div>
            </section >
        </div >




    )
}
