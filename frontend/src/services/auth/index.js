import { getHttpClient } from '@/config/HttpClinet';

const hc = getHttpClient('v1');

const authService = {
  // ログインAPI v1を使用
  login: (email, password) => {
    const response = hc.postForm('/auth/login', { 'email': email, 'password': password });
    if (response.data.token) {
      localStorage.setItem('token', response.data.token);
    }
    return response;
  },

  // 登録API v1を使用
  initiateRegistration: (email) => 
    hc.put('/auth/register/initiate', { email }),

  completeRegistration: (email, token, password) => 
    hc.post('/auth/register/complete', {
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