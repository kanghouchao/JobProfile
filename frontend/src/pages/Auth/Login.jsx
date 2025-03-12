import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useTranslation } from "react-i18next";  
import userService from '../../services/auth/authService';

const Login = () => {
  const { t } = useTranslation('auth');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await userService.login({ username, password });
      const token = response.data.token;
      localStorage.setItem('token', token);
      navigate('/');
    } catch (error) {
      console.error(error.message);
    }
  };

  return (
    <div className="flex h-screen">

      <div className="hidden md:flex flex-1 bg-cover bg-center" style={{ backgroundImage: "url('/images/register-bg.png')" }}>
      </div>
      
      <div className="w-full md:w-1/2 flex flex-col justify-center items-center p-6 md:p-12">
        <h2 className="text-3xl font-semibold mb-6">{t("login.title")}</h2>
        <form onSubmit={handleLogin} className="w-full max-w-md">
          <div className="mb-4">
            <label htmlFor="username" className="block text-sm font-medium text-gray-600">
              {t("login.username")}
            </label>
            <input
              type="email"
              id="username"
              name="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
              className="mt-2 p-3 w-full border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
          </div>

          <div className="mb-6">
            <label htmlFor="password" className="block text-sm font-medium text-gray-600">
              {t("login.password")}
            </label>
            <input
              type="password"
              id="password"
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              className="mt-2 p-3 w-full border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
          </div>

          <button
            type="submit"
            className="w-full py-3 bg-blue-500 text-white font-semibold rounded-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500"
          >
            {t("login.login")}
          </button>
        </form>

        <div className="mt-4 text-center">
          <p className="text-sm text-gray-600">
            {t("login.haveAccount")} {' '}
            <a href="/register" className="text-blue-500 hover:text-blue-600">
              {t("login.registerHere")}
            </a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;
