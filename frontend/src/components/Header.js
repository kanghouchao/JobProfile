import React from 'react';

const Header = () => {
  return (
    <header className="bg-white shadow p-4 flex items-center justify-between">
      <h2 className="text-xl font-bold">ユーズのメッセージ</h2>
      <button className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
        新しいメッセージ
      </button>
    </header>
  );
};

export default Header;