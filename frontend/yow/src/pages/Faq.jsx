import React from 'react'
import CardQa from '../components/CardQa'
import faqData from '../data/faqList'
import Button from '../components/btn/Button'
export default function Faq() {
    return (
        <div className='container mx-auto flex flex-col items-center justify-center lg:flex-row lg:h-screen my-6'>
            <div className='flex flex-col w-full lg:w-1/2 mr-3 self-baseline'>
                <div className='space-y-4'>
                    {faqData.map((qa, index) => (
                        <CardQa key={index} question={qa.question} answer={qa.answer} />
                    ))}
                </div>
            </div>
            <div className='flex flex-col w-full lg:w-1/2 ml-3 self-baseline'>
                <div className='text-zinc-900'>
                    <h3 className='font-semibold text-2xl mb-2'>Contáctanos:</h3>
                    <form className='bg-gray-100 p-8 rounded-md shadow-sm shadow-zinc-500 font-medium text-lg space-y-4'>
                        <div className='flex flex-col md:flex-row md:space-x-4'>
                            <div className='flex flex-col w-full md:w-1/2'>
                                <label htmlFor="nombre">Nombre</label>
                                <input type="text" id="nombre" className='border border-gray-300 px-3 py-2 rounded-md' />
                            </div>
                            <div className='flex flex-col w-full md:w-1/2'>
                                <label htmlFor="apellido">Apellido</label>
                                <input type="text" id="apellido" className='border border-gray-300 px-3 py-2 rounded-md' />
                            </div>
                        </div>

                        <div className='flex flex-col'>
                            <label htmlFor="">Correo electrónico</label>
                            <input type="text" className='border border-gray-300 px-3 py-2 rounded-md' />
                        </div>
                        <div className='flex flex-col'>
                            <label htmlFor="">Deja tu mensaje:</label>
                            <textarea className='border border-gray-300 px-3 py-2 rounded-md' name="" id="" cols="30" rows="10"></textarea>
                        </div>
                        <Button className="w-" text="enviar" />
                    </form>
                </div>
            </div>
        </div>


    )
}
