import httpClient from '../../config/HttpClinet';

const userService = {
  login: (loginData) => httpClient.postForm('login', loginData),
  register: (email) => httpClient.putForm('auth/register/send-mail', {'email': email}),
  createUser: (userData) => httpClient.post('auth/register/create-user', userData),
};

export default userService;