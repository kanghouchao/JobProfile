import { getHttpClient } from '../../config/HttpClinet';

const authService = {
  // ログインAPI v1を使用
  login: (email, password) => {
    const response = getHttpClient('v1').postForm('/auth/login', { email, password });
    if (response.data?.token) {
      localStorage.setItem('token', response.data.token);
    }
    return response;
  },

  // 登録API v1を使用
  initiateRegistration: (email) => 
    getHttpClient('v1').putForm('/auth/register/send-mail', { email }),

  completeRegistration: (email, token, password) => 
    getHttpClient('v1').post('/auth/register/create-user', {
      email,
      token,
      password
    }),

  // ログアウト処理
  logout: () => {
    localStorage.removeItem('token');
  },

  // ユーザー情報を取得
  getCurrentUser: () => {
    return JSON.parse(localStorage.getItem('user'));
  },

  // トークンを取得
  getToken: () => {
    return localStorage.getItem('token');
  },

  // 認証状態を確認
  isAuthenticated: () => {
    return !!localStorage.getItem('token');
  }
};

export default authService;