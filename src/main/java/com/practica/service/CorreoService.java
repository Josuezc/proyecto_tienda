/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.service;

import jakarta.mail.MessagingException;

/**
 *
 * @author maria
 */
public interface CorreoService {
    public void enviarCorreoHtml(
              String para, 
              String asunto, 
              String contenidoHtml) 
              throws MessagingException;
            
    
}
