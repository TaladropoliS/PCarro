<%--
  Created by IntelliJ IDEA.
  User: WAR
  Date: 21-10-2024
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<% String usuario = (String) request.getSession().getAttribute("usuario");%>--%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/PCarro">
            <jsp:include page="icons/homeMarket.jsp"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/PCarro">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/PCarro/Productos">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/PCarro/carro.jsp">Carro</a>
                </li>
                <c:if test="${usuario != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/PCarro/agregarProducto.jsp">Agregar Producto</a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav ms-auto">

                <c:choose>
                    <c:when test="${usuario != null}">
                        <span class="navbar-text">Bienvenido, <strong>${usuario}</strong></span>
                        <a class="nav-link" href="/PCarro/SessionCierre">LogOut</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="/PCarro/login.jsp">
                            <jsp:include page="icons/user.jsp"/>
                            LogIn
                        </a>
                    </c:otherwise>
                </c:choose>

                <%--                <% if (usuario == null) { %>--%>
                <%--                <a class="nav-link" href="/PCarro/login.jsp">--%>
                <%--                    <jsp:include page="icons/user.jsp"/>--%>
                <%--                    LogIn--%>
                <%--                </a>--%>
                <%--                <% } else { %>--%>
                <%--                <span--%>
                <%--                        class="navbar-text">Bienvenido, <strong><%= usuario %></strong>--%>
                <%--                    </span>--%>
                <%--                <a class="nav-link"--%>
                <%--                   href="/PCarro/SessionCierre">LogOut</a>--%>
                <%--                <% } %>--%>

            </ul>
        </div>
    </div>
</nav>