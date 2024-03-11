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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexa
 */

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
  
    @Autowired
    private CategoriasService categoriasService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var categorias = categoriasService.getCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "categorias/listado"; // Quita el slash al inicio
    }
    
    
     @GetMapping("/nuevo")
    public String categoriaNuevo(Categorias categoria) {
        return "/categorias/modifica";
    }

    //@Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
  /* @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            categoria.getId_producto()));
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

   */

    @GetMapping("/eliminar/{Id}")
    public String categoriaEliminar(Categorias categoria) {
        categoriasService.delete(categoria);
        return "redirect:/categorias/listado";
    }

    @GetMapping("/modifica/{id}")
    public String categoriaModificar(Categorias categoria, Model model) {
        categoria = categoriasService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categorias/modifica";
    }   
}
