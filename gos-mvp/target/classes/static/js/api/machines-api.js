const MachinesAPI = {
  getAll: () => axios.get('/machines'),
  getById: (id) => axios.get(`/machines/${id}`),
  create: (machine) => axios.post('/machines', machine),
  update: (id, machine) => axios.put(`/machines/${id}`, machine),
  delete: (id) => axios.delete(`/machines/${id}`)
};