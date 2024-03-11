/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Productos;
import java.util.List;

/**
 *
 * @author alexa
 */
public interface productosService {
   // Se obtiene un listado de categorias en un List
            public List<Productos> getProductos();
   
    // Se obtiene un Categoria, a partir del id de un categoria    
            public Productos getProducto(Productos productos);         
            // Se inserta un nuevo categoria si el id del categoria esta vacío    
            // Se actualiza un categoria si el id del categoria NO esta vacío   
            public void save(Productos productos);         
            // Se elimina el categoria que tiene el id pasado por parámetro   
            public void delete(Productos productos);
 
}