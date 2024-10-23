package com.pcarro.modelo.DAO;

import com.pcarro.modelo.DTO.Producto;

import java.util.List;

public interface IDAO<T> {
    List<T> listar();
    T porId(Long id);

    Boolean<T> agregar (Producto producto);
    Boolean<T> eliminar (Long id);
}
