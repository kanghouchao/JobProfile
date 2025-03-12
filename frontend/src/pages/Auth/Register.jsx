import React, { useState } from 'react';
import { FcGoogle } from "react-icons/fc";
import { FaLinkedin } from "react-icons/fa";
import userService from '../../services/auth/authService';
import { useNavigate } from 'react-router-dom';
import { useTranslation } from "react-i18next";

const Register = () => {
  const { t } = useTranslation('auth');
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

  return (
    <div className="flex h-screen">
      {/* Left Side - Background Image */}
      <div className="hidden md:flex flex-1 bg-cover bg-center" style={{ backgroundImage: "url('/images/register-bg.png')" }}>
      </div>

      {/* Right Side - Registration Form */}
      <div className="w-full md:w-1/2 flex flex-col justify-center items-center p-6 md:p-12">
        <h2 className="text-3xl font-semibold mb-6">{t('register.title')}</h2>
        <p className="text-gray-500 mb-4">{t('register.subtitle')}</p>
        
        <form onSubmit={handleSubmit} className="w-full max-w-sm">
          <input
            type="email"
            placeholder={t('register.emailPlaceholder')}
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="mb-4 w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none"
          />
          <button 
            type="submit" 
            className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition">
            {t('register.submit')}
          </button>
        </form>
        
        <div className="my-4 text-gray-400">{t('register.or')}</div>
        
        <div className="flex w-full max-w-sm space-x-4">
          <button className="flex-1 flex items-center justify-center p-3 border border-gray-300 rounded-lg hover:bg-gray-100 transition">
            <FcGoogle className="mr-2" size={20} /> {t('register.google')}
          </button>
          <button className="flex-1 flex items-center justify-center p-3 border border-gray-300 rounded-lg hover:bg-gray-100 transition">
            <FaLinkedin className="text-blue-700 mr-2" size={20} /> {t('register.linkedin')}
          </button>
        </div>
      </div>
    </div>
  );
}

export default Register;
