import httpClient from '../httpService';

const userService = {
  login: (loginData) => httpClient.postForm('login', loginData),
  register: (email) => httpClient.postForm('register/send-email', {'email': email}),
  createUser: (userData) => httpClient.post('register/create-user', userData),
};

export default userService;