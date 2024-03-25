/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexa
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/listado")
    public String showListadoPage() {
        // Lógica para mostrar la página de listado
        return "categorias/listado"; // Asegúrate de que esta sea la vista correcta
    }
    
}

 