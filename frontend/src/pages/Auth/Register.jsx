import React, { useState } from 'react';
import userService from '../../services/auth/authService';
import { useNavigate } from 'react-router-dom';

const Register = () => {
  const [email, setEmail] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await userService.register(email);
      navigate('/register-success');
    } catch (error) {
      console.error(error.message);
    }
  };

  const handleLoginRedirect = () => {
    navigate('/login');
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
      <div className="w-full max-w-md p-8 bg-white rounded-lg shadow-lg">
        <h2 className="text-2xl font-semibold text-center mb-6">Register</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label htmlFor="email" className="block text-sm font-medium text-gray-700">Email</label>
            <input
              type="email"
              id="email"
              name="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Enter your email"
              required
              className="mt-1 p-2 w-full border border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500"
            />
          </div>

          <button
            type="submit"
            className="w-full py-2 px-4 bg-indigo-600 text-white font-semibold rounded-md shadow-md hover:bg-indigo-700 focus:ring-2 focus:ring-indigo-500 mb-4"
          >
            Register
          </button>
        </form>

        <button
          onClick={handleLoginRedirect}
          className="w-full py-2 px-4 bg-gray-600 text-white font-semibold rounded-md shadow-md hover:bg-gray-700 focus:ring-2 focus:ring-gray-500"
        >
          Go to Login
        </button>
      </div>
    </div>
  );
};

export default Register;