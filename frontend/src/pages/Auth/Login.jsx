import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useTranslation } from 'react-i18next';
import createAuthService from '@/services/auth';
import { toast } from 'react-toastify';
import { FcGoogle } from 'react-icons/fc';
import { FaLinkedin } from 'react-icons/fa';

const Login = () => {
  const { t } = useTranslation('auth');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();

  // ログインフォームの送信処理
  const handleLogin = async e => {
    e.preventDefault();

    if (!email || !password) {
      toast.error(t('login.allFieldsRequired'));
      return;
    }

    setIsLoading(true);
    try {
      const authService = createAuthService();
      await authService.login(email, password);
      toast.success(t('login.success'));
      navigate('/');
    } catch (error) {
      toast.error(error.message || t('login.error'));
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="flex h-screen">
      {/* 左側：背景画像 */}
      <div
        className="hidden md:flex flex-1 bg-cover bg-center"
        style={{ backgroundImage: "url('/images/auth-bg.png')" }}
      ></div>

      {/* 右側：ログインフォーム */}
      <div className="w-full md:w-1/2 flex flex-col justify-center items-center p-6 md:p-12">
        <h2 className="text-3xl font-semibold mb-6">{t('login.title')}</h2>
        <p className="text-gray-500 mb-8">{t('login.subtitle')}</p>

        <form onSubmit={handleLogin} className="w-full max-w-sm space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              {t('login.email')}
            </label>
            <input
              type="email"
              name="email"
              required
              autoComplete="email"
              value={email}
              onChange={e => setEmail(e.target.value)}
              disabled={isLoading}
              className="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none disabled:bg-gray-100"
              placeholder={t('login.emailPlaceholder')}
            />
          </div>

          <div>
            <div className="flex justify-between items-center mb-1">
              <label className="block text-sm font-medium text-gray-700">
                {t('login.password')}
              </label>
              <Link to="/forgot-password" className="text-sm text-blue-600 hover:text-blue-700">
                {t('login.forgotPassword')}
              </Link>
            </div>
            <input
              type="password"
              name="password"
              required
              autoComplete="current-password"
              value={password}
              onChange={e => setPassword(e.target.value)}
              disabled={isLoading}
              className="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none disabled:bg-gray-100"
              placeholder={t('login.passwordPlaceholder')}
            />
          </div>

          <button
            type="submit"
            disabled={isLoading}
            className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition disabled:bg-blue-400"
          >
            {isLoading ? t('login.loggingIn') : t('login.submit')}
          </button>
        </form>

        <div className="mt-6 text-center">
          <p className="text-gray-600">
            {t('login.noAccount')}{' '}
            <Link to="/register" className="text-blue-600 hover:text-blue-700 font-medium">
              {t('login.register')}
            </Link>
          </p>
        </div>

        <div className="my-6 text-gray-400">{t('login.or')}</div>

        {/* ソーシャルログインボタン */}
        <div className="flex w-full max-w-sm space-x-4">
          <button className="flex-1 flex items-center justify-center space-x-2 p-3 border border-gray-300 rounded-lg hover:bg-gray-50 transition">
            <FcGoogle size={20} />
            <span>{t('login.google')}</span>
          </button>
          <button className="flex-1 flex items-center justify-center space-x-2 p-3 border border-gray-300 rounded-lg hover:bg-gray-50 transition">
            <FaLinkedin size={20} className="text-blue-600" />
            <span>{t('login.linkedin')}</span>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Login;
