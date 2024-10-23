<%--
  Created by IntelliJ IDEA.
  User: WAR
  Date: 23-10-2024
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio de Sesion</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<main class="container">
    <jsp:include page="components/navbar.jsp"/>

    <div class="col-md-4 mx-auto">
        <div class="card p-3">
            <form method="post" action="/ProyectoCarro/InicioSesion">
                <div class="mb-3">
                    <label for="usuario" class="form-label">Usuario:</label>
                    <input type="text" class="form-control" id="usuario" name="usuario">
                </div>
                <div class="mb-3">
                    <label for="clave" class="form-label">Clave:</label>
                    <input type="password" class="form-control" id="clave" name="clave">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>
</main>

<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
