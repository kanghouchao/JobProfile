import createHttpClient from '@/config/HttpClinet';

const createAiService = (hc = createHttpClient('v1')) => ({
  generate: async userInfo => {
    const response = await hc.postForm('/ai/generate', { userInfo });
    if (response.data.token) {
      localStorage.setItem('token', response.data.token);
    }
    return response;
  },
});

export default createAiService;
