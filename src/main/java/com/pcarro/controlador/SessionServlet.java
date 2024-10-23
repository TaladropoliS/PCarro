package com.pcarro.controlador;


import com.pcarro.modelo.DAO.ConexionBD;
import com.pcarro.modelo.DTO.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@WebServlet({"/InicioSesion", "/InicioSesionGet"})
public class SessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("usuario");
        String c = req.getParameter("clave");
        String sql = "SELECT * FROM usuarios WHERE nom_usu = '"+u+"' AND cla_usu = '"+c+"';";
        try (Statement st = ConexionBD.getInstance().createStatement();
             ResultSet rs = st.executeQuery(sql)
        ) {
            if(rs.next()){
                HttpSession session = req.getSession();
                session.setAttribute("usuario",rs.getString("nom_usu"));
                resp.sendRedirect(req.getContextPath() + "/InicioSesionGet");
            }else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en MySql. No existe el usuario en la BD.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario util = new Usuario();
        Optional<String> optionalUsuario = util.obtenerUsuario(req);

        if (optionalUsuario.isPresent()) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta chartset=\"UTF-8\">");
            out.println("    <title>Servlet</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("      <h1>Servlet de Inicio de Sesion</h1>");
            out.println("      <p>Bienvenido usuario '" + optionalUsuario.get() + "'.</p>");
            out.println("  <ul>");
            out.println("  <li><a href=index.jsp>Volver al inicio</a></li>");
            out.println("  <li><a href=CerrarSesion>Cerrar sesion</a></li>");
            out.println("  </ul>");
            out.println("  </body>");
            out.println("</html>");
            out.close();
        } else {
//            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
