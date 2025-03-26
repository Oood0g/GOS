axios.interceptors.request.use(config => {
    const token = localStorage.getItem('jwtToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  });
  
  axios.interceptors.response.use(
    response => response,
    error => {
      if (error.response.status === 401) {
        window.location.href = '/login.html';
      }
      return Promise.reject(error);
    }
  );

  // Configuração base do Axios
axios.defaults.baseURL = 'http://localhost:8080/api';

// Interceptor para JWT
axios.interceptors.request.use(config => {
    const token = localStorage.getItem('jwtToken');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

// Tratamento de erros
axios.interceptors.response.use(
    response => response,
    error => {
        if (error.response.status === 401) {
            window.location.href = '/login.html';
        }
        return Promise.reject(error);
    }
);