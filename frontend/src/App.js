import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from "./pages/Home";
import ResumeForm from "./pages/Resume";
import Register, { Login, PasswordSetting, RegisterSuccess } from "./pages/Auth";

const router = createBrowserRouter(
  [
    { path: "/", element: <Home /> },
    { path: "/register", element: <Register /> },
    { path: "/login", element: <Login /> },
    { path: "/password-setting", element: <PasswordSetting /> },
    { path: "/register-success", element: <RegisterSuccess /> },
    { path: "/resume", element: <ResumeForm /> },
  ],
  {
    future: {
      v7_startTransition: true,
    },
  }
);

const App = () => {
  return <RouterProvider router={router} />;
};

export default App;
