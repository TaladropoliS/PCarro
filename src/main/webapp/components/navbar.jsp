<%--
  Created by IntelliJ IDEA.
  User: WAR
  Date: 21-10-2024
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary text-center">
    <div class="container-fluid">
        <a class="navbar-brand" href="/PCarro">
            <jsp:include page="icons/cart.jsp"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav justify-content-center">
                <a class="nav-link" href="/PCarro">Home</a>
                <a class="nav-link" href="/PCarro/Productos">Productos</a>
                <a class="nav-link" href="/PCarro/carro.jsp">
                    <jsp:include page="/components/icons/cart.jsp"/>
                </a>
                <a class="nav-link" href="/PCarro/login.jsp">LogIn</a>
                <a class="nav-link" href="/PCarro/CerrarSesion">LogOut</a>
            </div>
        </div>
    </div>
</nav>