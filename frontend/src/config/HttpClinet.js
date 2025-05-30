import axios from 'axios';

const BASE_URL = process.env.REACT_APP_API_URL || '/';

const createHttpClient = version => {
  const client = axios.create({
    baseURL: `${BASE_URL}/api/${version}`,
    timeout: 1000,
    headers: {
      'Content-Type': 'application/json',
      Accept: 'application/json',
    },
  });

  // リクエストインターセプター
  client.interceptors.request.use(
    config => {
      const token = localStorage.getItem('token');
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
      return config;
    },
    error => Promise.reject(error)
  );

  // レスポンスインターセプター
  client.interceptors.response.use(
    response => {
      if (response.status === 200) {
        return response.data;
      } else {
        return Promise.reject(new Error(response.status, response.data));
      }
    },
    error => {
      console.error(error);
      return Promise.reject(error);
    }
  );

  return client;
};

export default createHttpClient;
