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

@WebServlet("/EditarProducto")
public class EditarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String tipo = req.getParameter("tipo");
        Integer precio = Integer.parseInt(req.getParameter("precio"));

        Producto nuevoProducto = new Producto(null, nombre, tipo, precio);
        ProductoDAO productoDAO = new ProductoDAO();
        Boolean respuesta = productoDAO.editar(nuevoProducto);

        if(respuesta){
            resp.sendRedirect("/PCarro/Productos");
        }else{
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al editar el producto");
        }
    }
}
