import React from 'react';
import router from '@/router';
import { RouterProvider } from 'react-router-dom';
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
