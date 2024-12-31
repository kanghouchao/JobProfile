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

const errorHandlers = [];
export const addErrorHandler = (handler) => {
  errorHandlers.push(handler);
};

httpClient.interceptors.response.use(
  (response) => response.data,
  (error) => {
    const { response } = error;
    errorHandlers.forEach((handler) => handler(response));
    return Promise.reject(error);
  }
);

export default httpClient;
