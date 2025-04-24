import React, { useState } from 'react';
import { FcGoogle } from "react-icons/fc";
import { FaLinkedin } from "react-icons/fa";
import { useNavigate } from 'react-router-dom';
import { useTranslation } from "react-i18next";
import authService from '@/services/auth';
import { toast } from 'react-toastify';

const Register = () => {
  const { t } = useTranslation('auth');
  const [email, setEmail] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();

  // 登録フォームの送信処理
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!email) {
      toast.error(t('register.emailRequired'));
      return;
    }

    setIsLoading(true);
    try {
      await authService.initiateRegistration(email);
      navigate('/register-success', { state: { email } });
      toast.success(t('register.checkEmail'));
    } catch (error) {
      console.error(error.message || t('register.error'));
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="flex h-screen">
      {/* 左側：背景画像 */}
      <div className="hidden md:flex flex-1 bg-cover bg-center" style={{ backgroundImage: "url('/images/auth-bg.png')" }}>
      </div>

      {/* 右側：登録フォーム */}
      <div className="w-full md:w-1/2 flex flex-col justify-center items-center p-6 md:p-12">
        <h2 className="text-3xl font-semibold mb-6">{t('register.title')}</h2>
        <p className="text-gray-500 mb-4">{t('register.subtitle')}</p>
        
        <form onSubmit={handleSubmit} className="w-full max-w-sm">
          <input
            type="email"
            name='email'
            required
            autoComplete="email"
            placeholder={t('register.emailPlaceholder')}
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            disabled={isLoading}
            className="mb-4 w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none disabled:bg-gray-100"
          />
          <button 
            type="submit" 
            disabled={isLoading}
            className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition disabled:bg-blue-400">
            {isLoading ? t('register.submitting') : t('register.submit')}
          </button>
        </form>
        
        <div className="my-4 text-gray-400">{t('register.or')}</div>
        
        {/* ソーシャルログインボタン */}
        <div className="flex w-full max-w-sm space-x-4">
          <button className="flex-1 flex items-center justify-center space-x-2 p-3 border border-gray-300 rounded-lg hover:bg-gray-50 transition">
            <FcGoogle size={20} />
            <span>{t('register.google')}</span>
          </button>
          <button className="flex-1 flex items-center justify-center space-x-2 p-3 border border-gray-300 rounded-lg hover:bg-gray-50 transition">
            <FaLinkedin size={20} className="text-blue-600" />
            <span>{t('register.linkedin')}</span>
          </button>
        </div>

        <div className="mt-6 text-gray-500">
          {t('register.haveAccount')}{' '}
          <a href="/login" className="text-blue-600 hover:underline">
            {t('register.login')}
          </a>
        </div>
      </div>
    </div>
  );
};

export default Register;
