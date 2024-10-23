<%--
  Created by IntelliJ IDEA.
  User: WAR
  Date: 23-10-2024
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pcarro.modelo.DTO.Carro" %>
<%@ page import="com.pcarro.modelo.DTO.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<html>
<head>
    <title>Carro de Compras</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<main class="container">
    <jsp:include page="components/navbar.jsp"/>

    <h1>Carro de Compras</h1>
    <% if (carro == null || carro.getItems().isEmpty()) { %>
    <p>No hay productos en el
        <jsp:include page="components/icons/cart.jsp"/>
    </p>
    <%} else {%>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
        </tr>
        <%for (Item item : carro.getItems()) {%>
        <tr>
            <td><%=item.getProducto().getId()%>
            </td>
            <td><%=item.getProducto().getNombre()%>
            </td>
            <td>$<%=item.getProducto().getPrecio()%>
            </td>
            <td><%=item.getCantidad()%>
            </td>
            <td>$<%=item.getTotal()%>
            </td>
        </tr>
        <%}%>
        <tr>
            <td colspan="4">Total</td>
            <td>$<%=carro.getTotal()%>
            </td>
        </tr>
    </table>
    <%}%>

    <div class="col-2 mx-auto mt-3">
        <a class="btn btn-outline-primary" href="/PCarro/Productos">Seguir Comprando</a>
    </div>

</main>

<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
