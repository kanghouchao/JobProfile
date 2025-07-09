import createHttpClient from '../../config/HttpClient';

const createAiService = (hc = createHttpClient('v1')) => ({
    generate: async userInfo => {
        const response = await hc.post('/ai/generate', { personalExperienceDescription: userInfo });
        return response;
    },
});

export default createAiService;
