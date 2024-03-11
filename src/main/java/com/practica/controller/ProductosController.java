/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Productos;
import com.practica.service.productosService;
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
@RequestMapping("/productos")
public class ProductosController {
  
    @Autowired
    private productosService productosService;
    
    @GetMapping("/listado")
private String listado(Model model) {
      
    var productos = productosService.getProductos();
    model.addAttribute("productos", productos);
    model.addAttribute("totalproductos", productos.size());
    return "/productos/listado";
   
}
    
    
     @GetMapping("/nuevo")
    public String categoriaNuevo(Productos productos) {
        return "/productos/modifica";
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
    public String categoriaEliminar(Productos productos) {
        productosService.delete(productos);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modifica/{id}")
    public String categoriaModificar(Productos productos, Model model) {
        productos = productosService.getProducto(productos);
        model.addAttribute("categoria", productos);
        return "/productos/modifica";
    }   
}
