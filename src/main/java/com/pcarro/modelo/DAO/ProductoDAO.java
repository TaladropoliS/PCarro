package com.pcarro.modelo.DAO;

import com.pcarro.modelo.DTO.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAO implements IDAO {

    private Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionBD.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<Producto>();
        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM productos;")) {
            while (rs.next()) {
                Producto p = new Producto(rs.getLong("id"), rs.getString("nombre"),
                        rs.getString("tipo"), rs.getInt("precio"));
                productos.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Optional<Producto> porId(Long id) {
        Optional<Producto> optionalProducto = null;
        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE id = " + id + ";")) {
            if (rs.next()) {
                optionalProducto = Optional.of(new Producto(rs.getLong("id"), rs.getString("nombre"),
                        rs.getString("tipo"), rs.getInt("precio")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return optionalProducto;
    }

    @Override
    public Boolean agregar(Producto producto) {
        String sql = "INSERT INTO PRODUCTOS (nombre, tipo, precio) VALUES('" + producto.getNombre() + "', '" + producto.getTipo() + "', " + producto.getPrecio() + "),";
        try (Statement st = conectar().createStatement()) {
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Boolean eliminar(Long id) {
        return null;
    }
}
