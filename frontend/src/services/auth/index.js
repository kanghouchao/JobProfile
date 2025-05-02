import createHttpClient from '@/config/HttpClinet';

const createAuthService = (hc = createHttpClient('v1')) => ({
  // ログインAPI v1を使用
  login: async (email, password) => {
    const response = await hc.post('/auth/login', { email, password });
    if (response.token) {
      localStorage.setItem('token', response.token);
    }
    return response;
  },

  // 登録API v1を使用
  initiateRegistration: async email => await hc.put('/auth/register/initiate', { email }),

  completeRegistration: (email, token, password) =>
    hc.post('/auth/register/complete', {
      email,
      token,
      password,
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
  },
});

export default createAuthService;
