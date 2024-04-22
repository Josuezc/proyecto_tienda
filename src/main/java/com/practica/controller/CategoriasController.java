/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Productos;
import com.practica.domain.Categorias;
import com.practica.domain.Item;
import com.practica.service.CategoriasService;
import com.practica.service.ItemService;
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
import org.springframework.web.servlet.ModelAndView;

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
public String listado(Model model, @PathVariable("idCategoria") Categorias idCategoria) {
    Categorias categoria = categoriaService.getCategoria(idCategoria);
   
    var productos = categoria.getProductos();
    var categorias = categoriaService.getCategorias();
    model.addAttribute("productos", productos);
    model.addAttribute("totalProductos", productos.size());
    model.addAttribute("categorias", categorias);
    return "/categorias/listado";
}

    @GetMapping("/listado2")
    private String listado2(Model model) {
        var productos = productosService.getProductos();
        model.addAttribute("productos", productos);
        return "/pruebas/listado2";
    }
 

    @Autowired
    private ItemService itemService;
    
    @GetMapping("/agregar/{id_producto}")
    public String agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Productos producto = productosService.getProducto(item);
            item2 = new Item(producto);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio_producto());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/categorias/ventana";
    }
}
