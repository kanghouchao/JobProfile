import React from 'react';
import Sidebar from './Sidebar';
import Header from './Header';

const Layout = ({ children }) => {
  return (
    <div className="flex h-screen">
      <Sidebar />
      <main className="flex-grow bg-gray-100 flex flex-col">
        <Header />
        <div className="flex-grow overflow-y-auto p-4">
            {children}
        </div>
      </main>
    </div>
  );
};

export default Layout;