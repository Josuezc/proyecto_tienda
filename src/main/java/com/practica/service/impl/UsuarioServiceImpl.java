/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service.impl;

import com.practica.service.UsuarioService;
import com.practica.domain.Usuario;
import com.practica.dao.UsuarioDao;
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
    }
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
}*/
  @Override
    @Transactional(readOnly = true)
    public Usuario getCategoria(Usuario Usuario) {
        return usuarioDao.findById(Usuario.getCedula_usuario()).orElse(null);
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
  
    
}
