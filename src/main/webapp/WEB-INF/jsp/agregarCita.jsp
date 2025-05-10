<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/9/2025
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Cita</title>
</head>
<body>
<h2>Agregar Cita</h2>

<form action="/citas/guardar" method="post">
    <label>Nombre del Paciente:</label>
    <input type="text" name="pacienteNombre" required><br><br>

    <label>Horario:</label>
    <input type="datetime-local" name="horario" required><br><br>

    <label>Doctor:</label>
    <select name="doctorId">
        <c:forEach var="doctor" items="${doctores}">
            <option value="${doctor.id}">
                    ${doctor.nombre} ${doctor.apellidoPaterno}
            </option>
        </c:forEach>
    </select><br><br>

    <label>Consultorio:</label>
    <select name="consultorioId">
        <c:forEach var="consultorio" items="${consultorios}">
            <option value="${consultorio.id}">
                Consultorio ${consultorio.numero} - Piso ${consultorio.piso}
            </option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Guardar Cita</button>
</form>
</body>
</html>
