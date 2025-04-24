import { createBrowserRouter } from "react-router-dom";
import Layout from "@/layout";
import Home from "@/pages/Home";
import ResumeForm, { JobHistoryForm } from "@/pages/Resume";
import PayPage from "@/pages/Pay";
import Register, { Login, PasswordSetting, RegisterSuccess, ForgotPassword } from "@/pages/Auth";

const router = createBrowserRouter(
  [
    { 
      path: "/", 
      element: <Layout />, 
      children: [
        { index: true, element: <Home /> },
        { path: "resume", element: <ResumeForm /> },
        { path: "job-history", element: <JobHistoryForm /> },
        { path: "pay", element: <PayPage /> }
      ]
    },
    { path: "login", element: <Login /> },
    { path: "register", element: <Register /> },
    { path: "password-setting", element: <PasswordSetting /> },
    { path: "register-success", element: <RegisterSuccess /> },
    { path: "forgot-password", element: <ForgotPassword /> },
  ],
  {
    future: {
      v7_startTransition: true,
    },
  }
);

export default router;