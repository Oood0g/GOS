document.addEventListener('DOMContentLoaded', async () => {
  // Carrega máquinas ao iniciar
  await loadMachines();
  
  // Evento do botão adicionar
  document.getElementById('addMachine').addEventListener('click', () => {
      window.location.href = '/machine-form.html';
  });
});

async function loadMachines() {
  try {
      const response = await MachinesAPI.getAll();
      const machines = response.data;
      
      const tableBody = document.querySelector('#machinesTable tbody');
      tableBody.innerHTML = machines.map(machine => `
          <tr>
              <td>${machine.code}</td>
              <td>${machine.description}</td>
              <td>${machine.model}</td>
              <td>
                  <button onclick="editMachine('${machine.id}')">Editar</button>
                  <button onclick="deleteMachine('${machine.id}')">Excluir</button>
              </td>
          </tr>
      `).join('');
  } catch (error) {
      console.error('Erro ao carregar máquinas:', error);
  }
}

window.editMachine = (id) => {
  window.location.href = `/machine-form.html?id=${id}`;
};

window.deleteMachine = async (id) => {
  if (confirm('Tem certeza que deseja excluir esta máquina?')) {
      await MachinesAPI.delete(id);
      await loadMachines();
  }
};