/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service.impl;

import com.practica.dao.RolDao;
import com.practica.service.UsuarioService;
import com.practica.domain.Usuario;
import com.practica.dao.UsuarioDao;
import com.practica.domain.Rol;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexa
 */

@Service
    public class UsuarioServiceImpl implements UsuarioService {
    /*
    @Autowired
    private UsuarioDao usuarioDao;
 @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
  @Override
@Transactional
public List<Usuario> getUsuarios() {
    
        return usuarioDao.findAll();
    
}
 @Override
    @Transactional(readOnly=true)
    public List<Usuario> getUsuariosActivos(boolean activos) {
        var lista=usuarioDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }*/
  /*  
  @Override
@Transactional
public Usuario getCategoria(Usuario usuario) {
    Optional<Usuario> usuarioOptional = usuarioDao.findById(usuario.getCedula_usuario());

    if (usuarioOptional.isPresent()) {
        Usuario storedUsuario = usuarioOptional.get();

        // Validar la contraseña
        if (storedUsuario.getContrasena_usuario().equals(usuario.getContrasena_usuario())) {
            return storedUsuario;
        }
    }

    return null; // Devolver null si no se encuentra el usuario o la contraseña es incorrecta
}*//*
  @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario Usuario) {
        return usuarioDao.findById(Usuario.getIdUsuario()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
     
    @Override
    
    public boolean existsByCedulaUsuario(long cedula_usuario) {
        return usuarioDao.existsById(cedula_usuario);
    }
  
     @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }*/
    
     @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        usuario=usuarioDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setId_usuario(usuario.getIdUsuario());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
     @Override
    @Transactional
    public void save1(Usuario usuario) {
        usuarioDao.save(usuario);
    }

}
