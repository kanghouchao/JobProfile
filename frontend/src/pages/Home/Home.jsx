import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Home = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (!token) {
      navigate('/login');
    }
  }, [navigate]);

  return (
    <div className="bg-gray-100 h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg w-full sm:w-96">
        <h2 className="text-2xl font-bold text-center text-gray-700 mb-6">
          Welcome to the Home Page
        </h2>
        <p className="text-sm text-gray-600 mb-6 text-center">
          You are logged in and can access this page.
        </p>
      </div>
    </div>
  );
};

export default Home;
