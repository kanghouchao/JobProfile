const environments = {
    development: 'http://localhost:8080',
    staging: 'http://test.job-pfile.com/api',
    production: 'https://job-pfile.com/api',
  };
  
const ENV = process.env.NODE_ENV || 'production';
  
export const baseURL = environments[ENV];
  