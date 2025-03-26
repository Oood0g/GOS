document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const response = await fetch('/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: document.getElementById('username').value,
            password: document.getElementById('password').value
        })
    });

    if (response.ok) {
        const { token } = await response.json();
        localStorage.setItem('jwt', token);
        window.location.href = '/dashboard.html';
    } else {
        alert('Login falhou!');
    }
});