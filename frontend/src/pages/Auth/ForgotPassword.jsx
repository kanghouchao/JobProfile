import React, { useState } from 'react';
import { useTranslation } from "react-i18next";
import { toast } from 'react-toastify';
import { Link } from 'react-router-dom';

const ForgotPassword = () => {
  const { t } = useTranslation('auth');
  const [email, setEmail] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const handleForgotPassword = async (e) => {
    e.preventDefault();

    if (!email) {
      toast.error(t('forgotPassword.emailRequired'));
      return;
    }

    setIsLoading(true);
    try {
      // 模拟发送重置密码请求
      await new Promise((resolve) => setTimeout(resolve, 1000));
      toast.success(t('forgotPassword.success'));
    } catch (error) {
      toast.error(t('forgotPassword.error'));
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="flex h-screen">
      {/* 左側：背景画像 */}
      <div className="hidden md:flex flex-1 bg-cover bg-center" style={{ backgroundImage: "url('/images/auth-bg.png')" }}>
      </div>

      {/* 右側：忘记密码フォーム */}
      <div className="w-full md:w-1/2 flex flex-col justify-center items-center p-6 md:p-12">
        <h2 className="text-3xl font-semibold mb-6">{t('forgotPassword.title')}</h2>
        <p className="text-gray-500 mb-8">{t('forgotPassword.subtitle')}</p>

        <form onSubmit={handleForgotPassword} className="w-full max-w-sm space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              {t('forgotPassword.email')}
            </label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              disabled={isLoading}
              className="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none disabled:bg-gray-100"
              placeholder={t('forgotPassword.emailPlaceholder')}
            />
          </div>

          <button
            type="submit"
            disabled={isLoading}
            className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition disabled:bg-blue-400">
            {isLoading ? t('forgotPassword.sending') : t('forgotPassword.submit')}
          </button>
        </form>

        <div className="mt-6 text-center">
          <p className="text-gray-600">
            {t('forgotPassword.remembered')}{' '}
            <Link to="/login" className="text-blue-600 hover:text-blue-700 font-medium">
              {t('forgotPassword.login')}
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default ForgotPassword;