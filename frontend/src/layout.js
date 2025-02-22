import React from 'react';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import { Outlet } from 'react-router-dom';

const Layout = () => {
  return (
    <div className="flex h-screen">
      <Sidebar />
      <main className="flex-grow bg-gray-100 flex flex-col">
        <Header />
        <div className="flex-grow overflow-y-auto p-4">
          <Outlet />
        </div>
      </main>
    </div>
  );
};

export default Layout;