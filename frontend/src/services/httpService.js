import axios from 'axios';

const baseURL = process.env.REACT_APP_API_URL || '/';

const httpClient = axios.create({
  baseURL,
  timeout: 1000,
  headers: {
    'Content-Type': 'application/json',
  },
});

httpClient.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => Promise.reject(error)
);

httpClient.interceptors.response.use(
  (response) => response.data,
  (error) => {
    const { response } = error;
    if (response) {
      const errorMessages = {
        400: '请求参数错误',
        401: '认证失败',
        403: '无权访问',
        404: '资源不存在',
        500: '服务器错误',
      };
      console.error(errorMessages[response.status] || '未知错误');
    } else {
      console.error('网络连接失败');
    }
    return Promise.reject(error);
  }
);

export default httpClient;
