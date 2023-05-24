// Asignar evento submit al formulario
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevenir envío del formulario

    var correo = document.getElementById('correo').value;
    var contrasena = document.getElementById('contrasena').value;

    var data = {
        correo: correo,
        contrasena: contrasena
    };
    // Realizar solicitud POST a localhost:8090/acceso/autenticacion
    fetch('http://localhost:8090/acceso/autenticacion', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            var token = data.token;
            //localstorage.setItem('token', token)
            console.log(token);
            localStorage.setItem("SavedToken", 'Bearer ' + token);
            // Verificar el token enviándolo al servidor
            fetch('http://localhost:8090/seguridad', {
                method: 'GET',
                headers: {
                    //'authorization':localstorage.getItem('token'),
                    'Authorization': localStorage.getItem('SavedToken')
                }
            })
                .then(function(response) {
                    if (response.ok) {
                        // El token es válido, redirigir a la página de seguridad
                        window.location.href = 'http://localhost:8090/seguridad';
                        document.getElementById('message').textContent = 'El token es valido';
                    } else {
                        // El token no es válido, mostrar un mensaje de error o redirigir al usuario
                        document.getElementById('message').textContent = 'Error al iniciar sesión';}
                })
                .catch(function(error) {
                    console.error('Error:', error);
                });
        })
        .catch(function(error) {
            console.error('Error:', error);
        });
});