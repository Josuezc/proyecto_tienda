/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Usuario;
import java.util.List;

public interface UsuarioService {
/*
    // Se obtiene un listado de categorias en un List
    public List<Usuario> getUsuarios();

    public List<Usuario> getUsuariosActivos(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria    
    public Usuario getUsuario(Usuario usuario);
    // Se inserta un nuevo categoria si el id del categoria esta vacío    
    // Se actualiza un categoria si el id del categoria NO esta vacío   

    public void save(Usuario usuario);
    // Se elimina el categoria que tiene el id pasado por parámetro   

    public void delete(Usuario usuario);

    public boolean existsByCedulaUsuario(long idUsuario);

    
    
    public Usuario getUsuarioPorUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameYPassword(String username, String password);
    
    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
  // boolean loginValidacion(long cedulaUsuario, String contrasena);*/
   public List<Usuario> getUsuarios();
   
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuario getUsuario(Usuario usuario);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuario getUsuarioPorUsername(String username);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameYPassword(String username, String password);
    
    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se valida si existe un Usuario considerando el username
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuario usuario,boolean crearRolUser);
   // public void save1(Usuario usuario);
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario); 
    
}
