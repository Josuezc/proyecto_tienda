/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Productos;
import com.practica.domain.Categorias;
import com.practica.service.CategoriasService;
import com.practica.service.productosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alexa
 */
@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private productosService productosService;
    @Autowired
    private CategoriasService categoriaService;

    @GetMapping("/listado")
    private String mostrarCategorias(Model model) {
        List<Categorias> categorias = categoriaService.getCategorias();
        var productos = productosService.getProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size());
        return "categorias/listado"; // Quita el slash al inicio
    }

@GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categorias categoria) {
         
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias();
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos",productos.size());
        model.addAttribute("categorias", categorias);
        return "/categorias/listado";
        
    
    }
    
   @GetMapping("/listado2")
    private String listado2(Model model) {
        var productos = productosService.getProductos();        
        model.addAttribute("productos", productos);       
        return "/categorias/listado2";
    }

}
