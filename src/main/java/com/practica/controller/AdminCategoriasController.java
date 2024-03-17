/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Categorias;
import com.practica.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexa
 */

@Controller
@RequestMapping("/adminCategoria")
public class AdminCategoriasController {
  
    @Autowired
    private CategoriasService categoriasService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var categorias = categoriasService.getCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "adminCategoria/listado"; // Quita el slash al inicio
    }
    
    
     @GetMapping("/nuevo")
    public String categoriaNuevo(Categorias categoria) {
        return "/adminCategoria/modifica";
    }

   @PostMapping("/guardar")
    public String categoriaGuardar(Categorias categoria){
            
            categoriasService.save(categoria);
        
        return "redirect:/adminCategoria/listado";
    }

    @GetMapping("/eliminar/{id_categoria}")
    public String categoriaEliminar(Categorias categoria) {
        categoriasService.delete(categoria);
        return "redirect:/adminCategoria/listado";
    }

    @GetMapping("/modifica/{id_categoria}")
    public String categoriaModificar(Categorias categoria, Model model) {
        categoria = categoriasService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/adminCategoria/modifica";
    }   
}
