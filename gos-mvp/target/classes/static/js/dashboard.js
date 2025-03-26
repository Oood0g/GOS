document.addEventListener('DOMContentLoaded', async () => {
    const ctx = document.getElementById('maintenanceChart').getContext('2d');
    const reportData = await ReportsAPI.getMaintenanceSummary();
    
    new Chart(ctx, {
      type: 'pie',
      data: {
        labels: ['Preventiva', 'Corretiva'],
        datasets: [{
          data: [reportData.preventive, reportData.corrective],
          backgroundColor: ['#4CAF50', '#F44336']
        }]
      }
    });
  });