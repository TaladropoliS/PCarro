package com.pcarro.controlador;

import com.pcarro.modelo.DAO.ProductoDAO;
import com.pcarro.modelo.DTO.Carro;
import com.pcarro.modelo.DTO.Item;
import com.pcarro.modelo.DTO.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/AgregarCarro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        ProductoDAO productoDAO = new ProductoDAO();
        Optional<Producto> productoOptional = productoDAO.porId(id);

        if(productoOptional.isPresent()){
            Item item = new Item(1,productoOptional.get());
            HttpSession session = req.getSession();
            Carro carro;
            if(session.getAttribute("carro") == null){
                carro = new Carro();
                session.setAttribute("carro",carro);
            }else{
                carro = (Carro) session.getAttribute("carro");
            }
            carro.setItems(item);
        }
        resp.sendRedirect(req.getContextPath() + "/VerCarro");
//        resp.sendRedirect("/PCarro/VerCarro");
    }
}
