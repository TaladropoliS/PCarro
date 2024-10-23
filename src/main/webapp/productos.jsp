<%--
  Created by IntelliJ IDEA.
  User: WAR
  Date: 23-10-2024
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.pcarro.controlador.ProductoServlet" %>
<%--<% String usuario = (String) request.getSession().getAttribute("usuario");%>--%>
<html>
<head>
    <title>Productos</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<main class="container">
    <jsp:include page="components/navbar.jsp"/>

    <h1 class="text-center">Productos</h1>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Tipo</th>
            <th class="text-end pe-5">Precio</th>
            <th class="text-center">Comprar</th>

            <c:if test="${usuario != null}">
                <th class="text-center">Acciones</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>${producto.tipo}</td>
                <td class="text-end pe-5">
                    <fmt:formatNumber value="${producto.precio}" type="number" groupingUsed="true"
                                      maxFractionDigits="0"/>
                </td>
                <th class="text-center">
                    <a class="btn btn-outline-primary" href="/PCarro/AgregarCarro?id=${producto.id}">
                        <jsp:include page="components/icons/cart_add.jsp"/>
                    </a>
                </th>
                <c:if test="${usuario != null}">
                    <th class="text-center">
                        <a class="btn btn-outline-primary mx-2" href="/PCarro/MostrarEditarProducto?id=${producto.id}">
                            <jsp:include page="components/icons/edit.jsp"/>
                        </a>
                        <a class="btn btn-outline-primary mx-2" href="/PCarro/EliminarProducto?id=${producto.id}">
                            <jsp:include page="components/icons/cart_delete.jsp"/>
                        </a>
                    </th>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
