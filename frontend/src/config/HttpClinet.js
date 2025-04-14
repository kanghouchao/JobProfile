import axios from 'axios';

const BASE_URL = process.env.REACT_APP_API_URL || '/';

// HTTPクライアントを作成
const createHttpClient = (version = '') => {
  const client = axios.create({
    baseURL: `${BASE_URL}api/${version}`,
    timeout: 1000
  });

  // リクエストインターセプター
  client.interceptors.request.use(
    (config) => {
      const token = localStorage.getItem('token');
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
      return config;
    },
    (error) => Promise.reject(error)
  );

  // レスポンスインターセプター
  client.interceptors.response.use(
    (response) => response.data,
    (error) => {
      const { response } = error;
      errorHandlers.forEach((handler) => handler(response));
      return Promise.reject(error);
    }
  );

  return client;
};

// エラーハンドラー
const errorHandlers = [];
export const addErrorHandler = (handler) => {
  errorHandlers.push(handler);
};

// クライアントキャッシュ
const clientsCache = new Map();

// バージョン指定のHTTPクライアントを取得
export const getHttpClient = (version = '') => {
  if (!clientsCache.has(version)) {
    clientsCache.set(version, createHttpClient(version));
  }
  return clientsCache.get(version);
};

export default getHttpClient();
