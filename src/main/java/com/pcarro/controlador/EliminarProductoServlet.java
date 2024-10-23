package com.pcarro.controlador;

import com.pcarro.modelo.DAO.ProductoDAO;
import com.pcarro.modelo.DTO.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/EliminarProducto")
public class EliminarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("id");
        ProductoDAO productoDAO = new ProductoDAO();

        Boolean respuesta = productoDAO.eliminar(Long.parseLong(id));

        if(respuesta){
            resp.sendRedirect("/PCarro/Productos");
        }else{
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el producto");
        }
    }
}
