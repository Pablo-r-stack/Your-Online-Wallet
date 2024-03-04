import './App.css'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HomePage from './pages/HomePage'
import Faq from './pages/Faq'
import Login from './pages/Login'
import Register from './pages/Register'
import ProtectedRoute from './pages/ProtectedRoute'
import { AuthProvider } from './auth/AuthProvider'
import Navbar1 from './components/Navbar1'
import Footer from './components/Footer'
import Dashboard from './pages/Dashboard';

function App() {
  return (
    <AuthProvider>
      <Router className="flex flex-col min-h-screen">
        <Navbar1 />
        <Routes className="flex-grow">
          <Route path="/" element={<HomePage />} />
          <Route path="/faq" element={<Faq />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route element={<ProtectedRoute />}>
            <Route path="/dashboard" element={<Dashboard />} />
          </Route>
        </Routes>
        <Footer />
      </Router>
    </AuthProvider>

  )
}

export default App;
