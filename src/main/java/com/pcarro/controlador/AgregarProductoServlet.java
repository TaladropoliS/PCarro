package com.pcarro.controlador;

import com.pcarro.modelo.DAO.ProductoDAO;
import com.pcarro.modelo.DTO.Producto;
import com.pcarro.modelo.DTO.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.spi.SPIResolutionException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


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

//        List<Producto> productos = productoDAO.listar();
//        Usuario util = new Usuario();
//        Optional<String> optionalUsuario = util.obtenerUsuario(req);

        if(respuesta){
            resp.sendRedirect("/PCarro/Productos");
        }else{
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el producto");
        }
    }
}
