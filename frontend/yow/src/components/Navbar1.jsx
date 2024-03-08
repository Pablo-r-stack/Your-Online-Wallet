
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../auth/AuthProvider';
import DropdownUser from './DropdownUser';


const Navbar1 = () => {
  const auth = useAuth();
  return (
    <nav className="bg-zinc-900 text-gray-100 py-4">
      <div className="max-w-7xl mx-auto px-4 flex justify-between items-center">
        <div className="flex items-center">
          <img className='w-16 mr-3 rounded-full' src="\src\img\icons\logo.png" alt="wallet icon" />
          <span className="text-lg font-bold">Your Online Wallet</span>

        </div>
        {!auth.isAuthenticated ?(
          <div className="flex space-x-4">
            <Link to="/" className="text-gray-100 hover:text-gray-300">Home</Link>
            <Link to="/register" className="text-gray-100 hover:text-gray-300">Registro</Link>
            <Link to="/login" className="text-gray-100 hover:text-gray-300">Login</Link>
          </div>)
        :
        (
          <div className="flex space-x-4 items-center">
            <Link to="/dashboard" className="text-gray-100 hover:text-gray-300">Dashboard</Link>
            <Link to="/login" className="text-gray-100 hover:text-gray-300"><DropdownUser /></Link>
          </div>
        )
      }
      </div>
    </nav>
  );
};

export default Navbar1;