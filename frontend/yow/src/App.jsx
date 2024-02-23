import { useState } from 'react'

import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomePage />}></Route>
      </Routes>
      <Footer></Footer>
    </BrowserRouter>
  )
}

export default App
