import React, { useEffect } from 'react';
import { Link,useNavigate } from 'react-router-dom';

const Sidebar = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (!token) {
      navigate('/login');
    }
  }, [navigate]);

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/login');
  }

  return (
    <aside className="w-1/4 bg-gray-800 text-white flex flex-col">
      <h1 className="text-2xl font-bold p-4 border-b border-gray-700">メニュー</h1>
      <nav className="flex-grow">
        <ul>
          <li className="p-4 hover:bg-gray-700 cursor-pointer">
            <Link to="/resume">履歴書</Link>
          </li>
          <li className="p-4 hover:bg-gray-700 cursor-pointer">機能2</li>
          <li className="p-4 hover:bg-gray-700 cursor-pointer">機能3</li>
        </ul>
      </nav>
      <button onClick={handleLogout} className="p-4 bg-red-500 hover:bg-red-600 text-white font-bold">ログアウト</button>
    </aside>
  );
};

export default Sidebar;