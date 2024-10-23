package com.pcarro.controlador;

import com.pcarro.modelo.DAO.ProductoDAO;
import com.pcarro.modelo.DTO.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/MostrarEditarProducto")
public class MostrarEditarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ProductoDAO productoDAO = new ProductoDAO();

        Optional<Producto> producto = productoDAO.porId(Long.parseLong(id));

        if (producto.isPresent()) {
            req.setAttribute("producto", producto.get());
            getServletContext().getRequestDispatcher("/editarProducto.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al editar producto");
        }

    }
}
