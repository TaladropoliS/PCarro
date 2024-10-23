package com.pcarro.modelo.DTO;

import java.util.Objects;

public class Item {
    private Integer cantidad;
    private Producto producto;

    public Item(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getTotal(){
        return cantidad * producto.getPrecio();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(producto.getId(), item.producto.getId())
                && Objects.equals(producto.getNombre(), item.producto.getNombre());
    }
}
