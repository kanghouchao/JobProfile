import React from 'react';
import { RouterProvider } from 'react-router-dom';
import router from '@/router';
import { ToastContainer } from 'react-toastify';

const App = () => {
  return (
    <>
      <RouterProvider router={router} />
      <ToastContainer />
    </>
  );
};

export default App;
