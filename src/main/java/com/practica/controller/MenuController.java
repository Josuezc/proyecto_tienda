/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Productos;
import com.practica.service.CategoriasService;
import com.practica.service.ItemService;
import com.practica.service.productosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexa
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private productosService productosService;
    @Autowired
    private CategoriasService categoriaService;

    

    @GetMapping("/listado")
    public String showListadoPage() {
        // Lógica para mostrar la página de listado
        return "categorias/listado"; // Asegúrate de que esta sea la vista correcta
    }

    @GetMapping("/carrusel/{idProducto}")

    public String listado(Model model, @PathVariable("idProducto") Productos Productos) {
        Productos producto = productosService.getProducto(Productos);
        model.addAttribute("productos", producto);
        return "index";
    }

    @GetMapping("/ubicacion")
    public String showubicacion() {

        return "/ubicacion/fragmento";
    }

   
}
