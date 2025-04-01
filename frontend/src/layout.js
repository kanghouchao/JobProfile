import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Outlet } from 'react-router-dom';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import { AlertProvider } from "./context/AlertContext"; 

const Layout = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (!token) {
      navigate('/login');
    }
  }, [navigate]);

  return (
    <AlertProvider>
      <div className="flex h-screen">
        <Sidebar />
        <main className="flex-grow bg-gray-100 flex flex-col">
          <Header />
          <div className="flex-grow overflow-y-auto p-4">
            <Outlet />
          </div>
        </main>
      </div>
    </AlertProvider>
  );
};

export default Layout;