package com.practica.controller;

import com.practica.domain.Item;
import com.practica.domain.Productos;
import com.practica.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.practica.service.productosService;

@Controller
public class CarritoController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private productosService productoService;
    
    @GetMapping("/")
    private String listado(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/index";
    }

    //Para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio_producto());
        }
        model.addAttribute("carritoTotal", 
                carritoTotalVenta);
        return "/carrito/listado";
    }    
   
    //Para Agregar un producto al carrito
    @GetMapping("/carrito/agregar/{id_producto}")
    public String agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Productos producto = productoService.getProducto(item);
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
        return "redirect:/categorias/listado";
    }
    
      @GetMapping("/carrito/sumar/{id_producto}")
    public String sumaItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Productos producto = productoService.getProducto(item);
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
        return "redirect:/carrito/listado";
    }
      @GetMapping("/carrito/restar/{id_producto}")
    public String restaItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Productos producto = productoService.getProducto(item);
            item2 = new Item(producto);
        }
        itemService.resta(item2);
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
        return "redirect:/carrito/listado";
    }

    //Para mofificar un producto del carrito
    @GetMapping("/carrito/modificar/{id_producto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modifica";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{id_producto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un producto del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    //Para facturar los productos del carrito... no implementado...
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/factura/listado";
    }
}