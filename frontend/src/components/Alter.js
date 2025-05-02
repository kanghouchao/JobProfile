import React from 'react';

const Alert = ({ message, type = 'error', onClose }) => {
  const typeStyles = {
    error: 'bg-red-500 text-white',
    success: 'bg-green-500 text-white',
    warning: 'bg-yellow-500 text-black',
  };

  return (
    <div
      className={`fixed top-5 left-1/2 transform -translate-x-1/2 px-4 py-2 rounded shadow-lg ${typeStyles[type]}`}
    >
      <div className="flex justify-between items-center">
        <span>{message}</span>
        <button className="ml-4" onClick={onClose}>
          ✖
        </button>
      </div>
    </div>
  );
};

export default Alert;
