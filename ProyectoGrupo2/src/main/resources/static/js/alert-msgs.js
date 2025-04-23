setTimeout(() => {
    const alerts = document.querySelectorAll('.alerta');
    alerts.forEach(alert => {
        setTimeout(() => alert.remove(), 300); //
    });
}, 4000);
