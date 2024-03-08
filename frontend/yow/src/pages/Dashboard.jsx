import React, { useEffect } from 'react';
import AccountCard from '../components/AccountCard';
import Movements from '../components/Movements';
import { useAuth } from '../auth/AuthProvider';
import { WalletProvider, useWallet } from '../auth/WalletProvider';

export default function Dashboard() {
  return (
    <WalletProvider>
      <DashboardContent />
    </WalletProvider>
  );
}

function DashboardContent() {
  const auth = useAuth();
  const wallet = useWallet();
  const user = auth.user;
  useEffect(() => {
    if (auth.isAuthenticated) {
      console.log('Trying to obtain users account');
      wallet.getAccount();
    } else {
      console.log('Error fetching wallet');
    }
  }, []);

  const { balance, movements } = wallet.getWallet();
  console.log(JSON.stringify(movements));

  return (
    <div className='container mx-auto flex-col items-center justify-center lg:flex-row lg:h-5/6 my-32 max-w-2xl'>
      <div className='my-4'>
        <AccountCard balance={balance} />
      </div>
      <div className='my-4'>
        <h3 className='font-semibold text-2xl'>Movimientos:</h3>
        {movements && movements.map((movement) => ( //Falta operador ternario para validar estado de la transaccion (pendiente recibir del back dicho atributo)
          <Movements
            transaction={
              movement.id.service == 'Recarga'
                ? 'Ingresaste Dinero'
                : movement.id.service == 'Transferencia'
                  ? 'Transferiste Dinero'
                  : 'Pago de Servicio'
            }
            ammount={movement.mount}
            date={movement.date}
          />
        ))}
      </div>
    </div>
  );
}