import React from 'react'
import Button from '../components/btn/Button'
import { useNavigate } from 'react-router-dom';
export default function HomePage() {
    const navigate = useNavigate();

    const handleRedirect = (path) => {
      navigate(path);
    };

    return (
        <div className='container max-w-full h-screen font-sans'>
          <section className='bg-zinc-900 h-2/4 p-8 lg:p-20 flex flex-col lg:flex-row'>
            <div className='text-gray-100 w-full lg:w-2/4 mt-8 lg:mt-0 ml-0 lg:ml-8'>
              <h1 className='text-3xl lg:text-7xl font-bold'>Bienvenido a tu Nueva Economía</h1>
              <p className='text-lg lg:text-2xl my-4'>Vive tu Experiencia YOW.</p>
            </div>
            <div className='w-full lg:w-2/4 flex justify-center items-center lg:justify-end'>
              <img className='w-2/3 lg:w-1/3 lg:m-72 rounded-full' src="\src\img\icons\logo.png" alt="wallet icon" />
            </div>
          </section>
          <section className='h-2/4 text-zinc-900  text-center flex flex-col justify-center'>
            <h2 className='text-3xl lg:text-5xl font-medium my-4 lg:my-10'>Bienvenido a Your Online Wallet</h2>
            <div className='space-y-4 lg:space-x-10 lg:space-y-0 flex flex-col lg:flex-row items-center justify-center'>
              <Button text="Registrar" onClick={() => handleRedirect('/register')} />
              <Button text="Login" onClick={() => handleRedirect('/login')} />
              <Button text="Acerca de" onClick={() => handleRedirect('/faq')} />
            </div>
          </section>
        </div>
      );
    }
