import { createBrowserRouter, Navigate } from 'react-router-dom';
import Layout from '@/layout';
import Home from '@/pages/Home';
import ResumeForm, { JobHistoryForm } from '@/pages/Resume';
import PayPage from '@/pages/Pay';
import Register, { Login, PasswordSetting, RegisterSuccess, ForgotPassword } from '@/pages/Auth';
import ResumeBasicStep from '@/pages/Resume/ResumeBasicStep';
import ResumeHistoryStep from '@/pages/Resume/ResumeHistoryStep';
import ResumeLicenseStep from '@/pages/Resume/ResumeLicenseStep';
import ResumePRStep from '@/pages/Resume/ResumePRStep';

const router = createBrowserRouter(
  [
    {
      path: '/',
      element: <Layout />,
      children: [
        { index: true, element: <Home /> },
        {
          path: 'resume',
          element: <ResumeForm />,
          children: [
            { index: true, element: <Navigate to="basic" replace /> },
            { path: 'basic', element: <ResumeBasicStep /> },
            { path: 'history', element: <ResumeHistoryStep /> },
            { path: 'license', element: <ResumeLicenseStep /> },
            { path: 'pr', element: <ResumePRStep /> },
          ],
        },
        { path: 'job-history', element: <JobHistoryForm /> },
        { path: 'pay', element: <PayPage /> },
      ],
    },
    { path: 'login', element: <Login /> },
    { path: 'register', element: <Register /> },
    { path: 'password-setting', element: <PasswordSetting /> },
    { path: 'register-success', element: <RegisterSuccess /> },
    { path: 'forgot-password', element: <ForgotPassword /> },
  ],
  {
    future: {
      v7_startTransition: true,
    },
  }
);

export default router;
