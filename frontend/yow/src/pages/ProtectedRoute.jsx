import React from 'react'
import { useAuth } from '../auth/AuthProvider'
import { Navigate, Outlet } from 'react-router-dom';

{/**Este nodo se encarga de validar que el usuario este autenticado, caso contrario lo redirige a la ruta predefinida (login en este caso) */}
export default function ProtectedRoute() {
    const auth = useAuth();

    if (!auth.isAuthenticated) {
        console.log('Access denied please log in first');
        // Si no está autenticado, redirige al login
        return <Navigate to="/login" />;
    }

    // Si el usuario está autenticado, renderizar las rutas secundarias
    return <Outlet />;
}