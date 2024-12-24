import React from 'react';

const RegisterSuccess = () => {
  return (
    <div className="bg-gray-100 h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg w-full sm:w-96">
        <h2 className="text-2xl font-bold text-center text-gray-700 mb-6">
          Registration Successful
        </h2>
        <p className="text-sm text-gray-600 mb-6 text-center">
          A confirmation email has been sent to your inbox. Please check your
          inbox (and possibly your spam folder) to complete your registration.
        </p>
      </div>
    </div>
  );
};

export default RegisterSuccess;
