<%--
  Created by IntelliJ IDEA.
  User: othon
  Date: 5/9/2025
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Cita</title>
</head>
<body>
<h2>Agregar Cita</h2>

<form action="/citas/registrar" method="post">
    <label>Nombre del Paciente:</label>
    <input type="text" name="pacienteNombre" required><br><br>

   <%-- <label>Horario:</label>
    <input type="datetime-local" name="horario" required><br><br>--%>

    <label>Horario (yyyy-MM-dd HH:mm:ss):</label><br>
    <input type="text" name="horario" required /><br><br>

    <label>Doctor:</label>

    <select name="doctorId">
        <c:forEach var="doctor" items="${doctores}">
            <option value="${doctor.doctorId}">
                    ${doctor.nombre} ${doctor.apellidoPaterno}
            </option>
        </c:forEach>
    </select><br><br>

    <label>Consultorio:</label>
    <select name="consultorioId">
        <c:forEach var="consultorio" items="${consultorios}">
            <option value="${consultorio.consultorioId}">
                Consultorio ${consultorio.numeroConsultorio} - Piso ${consultorio.piso}
            </option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Guardar Cita</button>
</form>
</body>
</html>