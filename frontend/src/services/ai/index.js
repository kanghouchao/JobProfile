import getHttpClient from "@/config/HttpClinet";

const hc = getHttpClient("v1");

const aiService = {
  generate: async (userInfo) => {
    const response = await hc.postForm("/ai/generate", { userInfo });
    if (response.data.token) {
      localStorage.setItem("token", response.data.token);
    }
    return response;
  },
};

export default aiService;
