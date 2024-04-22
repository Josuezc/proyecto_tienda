/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexa
 */
public interface RegistroService {
    public Model activar(Model model, String usuario, String Clave);
    public Model crearUsuario(Model model, Usuario usuario)throws MessagingException;
    public void activar(Usuario usuario, MultipartFile imageFile);
    public Model recordarUsuario(Model model, Usuario usuario)throws MessagingException;
}
