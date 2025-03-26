const AuthAPI = {
  login: async (credentials) => {
      const response = await axios.post('/auth/login', credentials);
      localStorage.setItem('jwtToken', response.data.token);
      return response.data;
  },
  
  logout: () => {
      localStorage.removeItem('jwtToken');
  }
};