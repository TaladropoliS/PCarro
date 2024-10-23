package com.pcarro.modelo.DAO;

import java.util.List;

public interface IDAO<T> {
    List<T> listar();
    T porId(Long id);
}
