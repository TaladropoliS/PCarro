package com.pcarro.controlador;

import com.pcarro.modelo.DAO.ProductoDAO;
import com.pcarro.modelo.DTO.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.spi.SPIResolutionException;

import java.io.IOException;


@WebServlet("/AgregarProducto")
public class AgregarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String tipo = req.getParameter("tipo");
        Integer precio = Integer.parseInt(req.getParameter("precio"));

        Producto nuevoProducto = new Producto(null, nombre, tipo, precio);

        ProductoDAO productoDAO = new ProductoDAO();

        Boolean respuesta = productoDAO.agregar(nuevoProducto);

        if(respuesta){
            resp.sendRedirect(req.getContextPath() + "/productos.jsp");
        }else{
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el producto");
        }
    }
}
