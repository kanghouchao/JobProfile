import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { useTranslation } from 'react-i18next';

const Sidebar = () => {
  const { t } = useTranslation('components');
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/login');
  };

  return (
    <aside className="w-1/6 bg-gray-800 text-white flex flex-col">
      <h1 className="text-2xl font-bold p-4 border-b border-gray-700">{t('siteTitle')}</h1>
      <nav className="flex-grow">
        <ul>
          <li className="p-4 hover:bg-gray-700 cursor-pointer">
            <Link to="/resume" className="block p-2">
              {t('resume')}
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700 cursor-pointer">
            <Link to="/job-history" className="block p-2">
              {t('jobProfile')}
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700 cursor-pointer">
            <Link to="/pay" className="block p-2">
              {t('pay')}
            </Link>
          </li>
        </ul>
      </nav>
      <button
        onClick={handleLogout}
        className="p-4 bg-red-500 hover:bg-red-600 text-white font-bold"
      >
        {t('logout')}
      </button>
    </aside>
  );
};

export default Sidebar;
