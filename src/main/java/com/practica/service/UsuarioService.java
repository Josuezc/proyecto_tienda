/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    // Se obtiene un listado de categorias en un List
    public List<Usuario> getUsuarios();

    public List<Usuario> getUsuariosActivos(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria    
    public Usuario getCategoria(Usuario usuario);
    // Se inserta un nuevo categoria si el id del categoria esta vacío    
    // Se actualiza un categoria si el id del categoria NO esta vacío   

    public void save(Usuario usuario);
    // Se elimina el categoria que tiene el id pasado por parámetro   

    public void delete(Usuario usuario);

    public boolean existsByCedulaUsuario(long cedula_usuario);

  // boolean loginValidacion(long cedulaUsuario, String contrasena);
}
