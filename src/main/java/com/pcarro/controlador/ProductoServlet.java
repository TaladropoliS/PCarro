package com.pcarro.controlador;


import com.pcarro.modelo.DAO.ProductoDAO;
import com.pcarro.modelo.DTO.Producto;
import com.pcarro.modelo.DTO.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/ProductosGet" , "/Productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario util = new Usuario();
        ProductoDAO productoDAO = new ProductoDAO();
        Optional<String> optionalUsuario = util.obtenerUsuario(req);
        List<Producto> productos = productoDAO.listar();

        req.setAttribute("productos", productos);
        req.setAttribute("usuario", optionalUsuario.orElse(null));

        getServletContext().getRequestDispatcher("/productos.jsp").forward(req, resp);
    }
}
