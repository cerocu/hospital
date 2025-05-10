<%--
  Created by IntelliJ IDEA.
  User: othon
  Date: 5/9/2025
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Consultar Citas</title>

</head>
<body>
<h1>Listado de Citas</h1>
<form method="get" action="/citas/consulta">
    Fecha y Hora (yyyy-MM-dd HH:mm:ss):
    <input type="text" name="fechaInicio" placeholder="2023-09-15 10:00:00" required />
    Fecha y Hora fin (yyyy-MM-dd HH:mm:ss):
    <input type="text" name="fechaFin" placeholder="2023-09-15 10:00:00" required />
    Consultorio id: <input type="text" name="consultorioId" />
    Doctor id: <input type="text" name="doctorId" />
    <button type="submit">Buscar</button>
</form>

<br/>

<table border="1">
    <thead>
    <tr>
        <th>Doctor</th>
        <th>Consultorio</th>
        <th>piso</th>
        <th>Horario</th>
        <th>Paciente</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cita" items="${citas}">
        <tr>
            <td>${cita.doctor.nombre}</td>
            <td>${cita.consultorio.numeroConsultorio}</td>
            <td>${cita.consultorio.piso}</td>
            <td>${cita.horarioConsulta}</td>
            <td>${cita.nombrePaciente}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>