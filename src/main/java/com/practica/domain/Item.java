package com.practica.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Productos {
    private int cantidad; //Almacenar la cantidad de items de un producto

    public Item() {
    }

    public Item(Productos producto) {
        super.setId_producto(producto.getId_producto());
        super.setId_categoria(producto.getId_categoria());
        super.setDescripcion_producto(producto.getDescripcion_producto());
       super.setNombre_producto(producto.getNombre_producto());
        super.setPrecio_producto(producto.getPrecio_producto());
        super.setCantidad_producto(producto.getCantidad_producto());
        
        super.setImagenfile(producto.getImagenfile());
        this.cantidad = 0;
    }
}