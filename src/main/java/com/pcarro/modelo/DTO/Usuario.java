package com.pcarro.modelo.DTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class Usuario {

    public Optional<String> obtenerUsuario(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("usuario");
        if (usuario != null) {
            return Optional.of(usuario);
        }
        return Optional.empty();
    }
}
