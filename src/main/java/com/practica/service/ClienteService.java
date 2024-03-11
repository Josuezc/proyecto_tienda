/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Cliente;
import java.util.List;

public interface ClienteService {

    // Se obtiene un listado de categorias en un List
    public List<Cliente> getClientes();

    public List<Cliente> getClientesActivos(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria    
    public Cliente getCategoria(Cliente cliente);
    // Se inserta un nuevo categoria si el id del categoria esta vacío    
    // Se actualiza un categoria si el id del categoria NO esta vacío   

    public void save(Cliente cliente);
    // Se elimina el categoria que tiene el id pasado por parámetro   

    public void delete(Cliente cliente);

    public boolean existsByCedulaUsuario(long cedula_usuario);

  // boolean loginValidacion(long cedulaUsuario, String contrasena);
}
