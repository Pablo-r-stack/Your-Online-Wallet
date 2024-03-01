import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import Navbar1 from './components/Navbar1'
import Faq from './pages/Faq'
import Login from './pages/Login'
import Register from './pages/Register'


function App() {

  return (
    <BrowserRouter>
      <div className="flex flex-col min-h-screen">
        <Navbar1 />
        <div className="flex-grow">
          <Routes>
            <Route path='/' element={<HomePage />} />
            <Route path='/faq' element={<Faq />} />
            <Route path='/login' element={<Login />} />
            <Route path='/register' element={<Register />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </BrowserRouter>
  )
}

export default App;
