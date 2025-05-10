<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/9/2025
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital - Panel Principal</title>
</head>
<body>
<h1>Bienvenido al Sistema de Citas del Hospital</h1>

<ul>
    <li><a href="${pageContext.request.contextPath}/citas/consulta">Consultar Citas</a></li>
    <li><a href="${pageContext.request.contextPath}/citas/agregar">Registrar Nueva Cita</a></li>
</ul>
</body>
</html>
