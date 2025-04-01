import httpClient from '@/config/HttpClinet';

const aiService = {
  login: (loginData) => httpClient.postForm('login', loginData)
};

export default aiService;