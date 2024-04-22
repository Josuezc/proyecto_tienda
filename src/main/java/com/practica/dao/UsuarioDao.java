/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.dao;


import com.practica.domain.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UsuarioDao extends JpaRepository <Usuario,Long> {
   Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
