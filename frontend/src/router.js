import { createBrowserRouter } from "react-router-dom";
import Layout from "./layout";
import Home from "./pages/Home";
import ResumeForm from "./pages/Resume";
import Register, { Login, PasswordSetting, RegisterSuccess } from "./pages/Auth";

const router = createBrowserRouter(
  [
    { 
      path: "/", 
      element: <Layout />, 
      children: [
        { index: true, element: <Home /> },
        { path: "register", element: <Register /> },
        { path: "login", element: <Login /> },
        { path: "password-setting", element: <PasswordSetting /> },
        { path: "register-success", element: <RegisterSuccess /> },
        { path: "resume", element: <ResumeForm /> }
      ]
    }
  ],
  {
    future: {
      v7_startTransition: true,
    },
  }
);

export default router;