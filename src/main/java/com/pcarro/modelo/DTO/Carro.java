package com.pcarro.modelo.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<Item> items;

    public Carro() {
        this.items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item itemCarro) {
        if(items.contains(itemCarro)){
            Optional<Item> optionalItem = items.stream().filter(i -> i.equals(itemCarro)).findAny();
            if(optionalItem.isPresent()){
                Item i = optionalItem.get();
                i.setCantidad(i.getCantidad()+1);
            }
        }else{
            this.items.add(itemCarro);
        }
    }

    public Integer getTotal() {
        /*Esto se puede hacer a través de programación OO tomando la lista
        y recorriéndola con un foreach. En cada vuelta habría que extraer el total de cada item
        con el método getTotal() y irlo sumando con los totales de los demás items. Al final
        se debería devolver la sumotaria total*/
        return items.stream().mapToInt(Item::getTotal).sum();
    }
}
