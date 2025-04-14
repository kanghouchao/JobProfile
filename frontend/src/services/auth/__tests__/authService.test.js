import authService from '../index';
import { getHttpClient } from '../../../config/HttpClinet';

jest.mock('../../../config/HttpClinet', () => ({
  getHttpClient: jest.fn(),
}));

describe('authService', () => {
  const mockHttpClient = {
    postForm: jest.fn(),
    putForm: jest.fn(),
    post: jest.fn(),
  };

  beforeEach(() => {
    getHttpClient.mockReturnValue(mockHttpClient);
  });

  it('should call login API with correct parameters', async () => {
    const mockResponse = { data: { token: 'mockToken' } };
    mockHttpClient.postForm.mockResolvedValueOnce(mockResponse);

    const response = await authService.login('test@example.com', 'password123');

    expect(mockHttpClient.postForm).toHaveBeenCalledWith('/auth/login', {
      email: 'test@example.com',
      password: 'password123',
    });
    expect(response).toEqual(mockResponse);
  });

  it('should call initiateRegistration API with correct parameters', async () => {
    const mockResponse = { data: { success: true } };
    mockHttpClient.putForm.mockResolvedValueOnce(mockResponse);

    const response = await authService.initiateRegistration('test@example.com');

    expect(mockHttpClient.putForm).toHaveBeenCalledWith('/auth/register/initiate', {
      email: 'test@example.com',
    });
    expect(response.data.success).toBe(true);
  });
});