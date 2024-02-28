import React from 'react'
import AccountCard from '../components/AccountCard'
import Movements from '../components/Movements'

export default function Dashboard() {
  return (
    <div className='container mx-auto flex-col items-center justify-center lg:flex-row lg:h-5/6 my-32 max-w-2xl'>
      <div className='my-4'> {/* Agregamos margen vertical para separar los elementos */}
        <AccountCard />
      </div>
      <div className='my-4'> {/* Agregamos margen vertical para separar los elementos */}
        <h3 className='font-semibold text-2xl'>Movimientos:</h3>
        <Movements transaction="Pagaste NetFlix" ammount='$5352.00' />
      </div>
    </div>
  )
}
