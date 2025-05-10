<%--
  Created by IntelliJ IDEA.
  User: othon
  Date: 5/9/2025
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>Consultar Citas</title>
<script>
    function cargarCitas() {
        fetch('/api/citas/getcitas')
            .then(response => response.json())
    .then(data => {
            const tabla = document.getElementById('tablaCitas');
        tabla.innerHTML = '';
        data.forEach(cita => {
            const fila = document.createElement('tr');
        fila.innerHTML = `
                            <td>${cita.doctor.nombre} ${cita.doctor.apellidoPaterno}</td>
                            <td>${cita.consultorio.numero}</td>
                            <td>${cita.horario}</td>
                            <td>${cita.pacienteNombre}</td>
                        `;
        tabla.appendChild(fila);
    });
    })
    .catch(error => console.error('Error al cargar las citas:', error));
    }

    window.onload = cargarCitas;
</script>
</head>
<body>
<h1>Listado de Citas</h1>
<table border="1">
    <thead>
    <tr>
        <th>Doctor</th>
        <th>Consultorio</th>
        <th>Horario</th>
        <th>Paciente</th>
    </tr>
    </thead>
    <tbody id="tablaCitas">
    <!-- Las citas se cargarán aquí -->
    </tbody>
</table>
</body>
</html>