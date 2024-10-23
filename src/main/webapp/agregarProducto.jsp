<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pcarro.modelo.DTO.Carro" %>
<%@ page import="com.pcarro.modelo.DTO.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head><title>Agregar Producto</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<main class="container">
    <jsp:include page="components/navbar.jsp"/>
    <div class="col-md-6 mx-auto">
        <div class="card p-3">
            <form method="post" action="/PCarro/AgregarProducto">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre del Producto:</label>
                    <input type="text"
                           class="form-control"
                           id="nombre"
                           name="nombre"
                           required>
                </div>
                <div class="mb-3">
                    <label for="precio" class="form-label">Precio:</label>
                    <input type="number"
                           class="form-control"
                           id="precio"
                           name="precio" min="0"
                           required>
                </div>
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo:</label>
                    <input type="text"
                           class="form-control"
                           id="tipo"
                           name="tipo"
                           required>
                </div>
                <button type="submit" class="btn btn-primary">Agregar Producto</button>
            </form>
        </div>
    </div>
</main>

<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
