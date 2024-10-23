package com.pcarro.modelo.DAO;

import com.pcarro.modelo.DTO.Producto;

import java.util.List;

public interface IDAO<T> {
    List<T> listar();

    T porId(Long id);

    Boolean agregar(Producto producto);

    Boolean eliminar(Long id);

    Boolean editar(Producto producto);
}
