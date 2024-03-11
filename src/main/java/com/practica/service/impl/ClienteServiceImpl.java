/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service.impl;

import com.practica.service.ClienteService;
import com.practica.domain.Cliente;
import com.practica.dao.ClienteDao;
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
    public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;
 @Autowired
    public ClienteServiceImpl(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }
  @Override
@Transactional
public List<Cliente> getClientes() {
    
        return clienteDao.findAll();
    
}
 @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientesActivos(boolean activos) {
        var lista=clienteDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
  @Override
@Transactional
public Cliente getCategoria(Cliente cliente) {
    Optional<Cliente> clienteOptional = clienteDao.findById(cliente.getCedula_usuario());

    if (clienteOptional.isPresent()) {
        Cliente storedCliente = clienteOptional.get();

        // Validar la contraseña
        if (storedCliente.getContrasena_cliente().equals(cliente.getContrasena_cliente())) {
            return storedCliente;
        }
    }

    return null; // Devolver null si no se encuentra el cliente o la contraseña es incorrecta
}

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
     
    @Override
    
    public boolean existsByCedulaUsuario(long cedula_usuario) {
        return clienteDao.existsById(cedula_usuario);
    }
  
    
}
