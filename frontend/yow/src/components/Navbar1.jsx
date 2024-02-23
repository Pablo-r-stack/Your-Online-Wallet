
import React from 'react';
import { Link } from 'react-router-dom';


const Navbar1 = () => {
  return (
    <nav className="bg-zinc-900 text-white py-4">
      <div className="max-w-7xl mx-auto px-4 flex justify-between items-center">
        <div className="flex items-center">
        <img className='w-16 mr-3 rounded-full' src="\src\img\icons\logo.png" alt="wallet icon" />
          <span className="text-lg font-bold">You Online Wallet</span>

        </div>
        <div className="flex space-x-4">
          <Link to="/" className="text-white hover:text-gray-300">Home</Link>
          <Link to="/register" className="text-white hover:text-gray-300">Registro</Link>
          <Link to="/login" className="text-white hover:text-gray-300">Login</Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar1;