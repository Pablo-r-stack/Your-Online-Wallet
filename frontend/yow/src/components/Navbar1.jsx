
import React from 'react';


const Navbar1 = () => {
  return (
    <nav className="bg-gray-800 text-white py-4">
      <div className="max-w-7xl mx-auto px-4 flex justify-between items-center">
        <div className="flex items-center">
          <span className="text-lg font-bold">Mi Sitio Web</span>
        </div>
        <div className="flex space-x-4">
          <Link to="/pagina1" className="text-white hover:text-gray-300">Pagina 1</Link>
          <Link to="/pagina2" className="text-white hover:text-gray-300">Pagina 2</Link>
          <Link to="/pagina3" className="text-white hover:text-gray-300">Pagina 3</Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar1;