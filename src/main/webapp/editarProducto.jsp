<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pcarro.modelo.DTO.Carro" %>
<%@ page import="com.pcarro.modelo.DTO.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<% String usuario = (String) request.getSession().getAttribute("usuario");%>--%>

<html>
<head><title>Editar Producto</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<main class="container">
    <jsp:include page="components/navbar.jsp"/>
    <div class="col-md-6 mx-auto">
        <div class="card p-3">
            <c:choose>
                <c:when test="${usuario != null}">
                    <form method="post" action="/PCarro/EditarProducto">

                            <%--                        Pasar el ID del producto--%>
                        <input type="hidden" name="id" value="${producto.id}">

                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre del Producto:</label>
                            <input type="text"
                                   class="form-control"
                                   id="nombre"
                                   name="nombre"
                                   value="${producto.nombre}"
                                   required>
                        </div>
                        <div class="mb-3">
                            <label for="precio" class="form-label">Precio:</label>
                            <input type="number"
                                   class="form-control"
                                   id="precio"
                                   name="precio" min="0"
                                   value="${producto.precio}"
                                   required>
                        </div>
                        <div class="mb-3">
                            <label for="tipo" class="form-label">Tipo:</label>
                            <input type="text"
                                   class="form-control"
                                   id="tipo"
                                   name="tipo"
                                   value="${producto.tipo}"
                                   required>
                        </div>
                        <button type="submit" class="btn btn-primary">Editar Producto</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="mt-5">
                        <p class="text-center mt-5">Necesitas estar logueado para agregar productos al
                            <jsp:include page="components/icons/cart.jsp"/>
                        </p>
                        <a class="nav-link col-2 mt-3 mx-auto" href="/PCarro/login.jsp">
                            <button class="mt-3 btn btn-outline-primary">LogIn</button>
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</main>

<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
