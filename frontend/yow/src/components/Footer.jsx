import React from 'react'
import { Link } from 'react-router-dom'

export default function Footer() {
    return (
        <footer className='container; text-center text-sm space-y-0 font-sans'>
            <ul className='inline-flex space-x-1 font-normal text-blue-900'>
                <li className='hover:font-medium transition-all'><Link to="/">Home</Link></li>
                <li className='hover:font-medium transition-all'><Link>About us</Link></li>
                <li className='hover:font-medium transition-all'><Link to="/faq">Faq</Link></li>
            </ul>
            <h6 className='font-semibold text-gray-800'>2024- Your Online Wallet ®</h6>
            <p className='text-xs italic'>all rights reserved</p>
        </footer>
    )
}
