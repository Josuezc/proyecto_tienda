package com.practica.service.impl;

import com.practica.dao.FacturaDao;
import com.practica.dao.VentaDao;
import com.practica.domain.Productos;
import com.practica.domain.Usuario;
import com.practica.domain.Factura;
import com.practica.domain.Item;
import com.practica.domain.Venta;
import com.practica.service.UsuarioService;
import com.practica.service.ItemService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.practica.dao.ProductosDao;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            //Busca si ya existe el producto en el carrito
            if (Objects.equals(i.getId_producto(), item.getId_producto())) {
                //Valida si aún puede colocar un item adicional -segun existencias-
                if (i.getCantidad() < item.getCantidad_producto()) {
                    //Incrementa en 1 la cantidad de elementos
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {//Si no está el producto en el carrito se agrega cantidad =1.            
            item.setCantidad(1);
            listaItems.add(item);
        }
    }
      @Override
    public void resta(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            //Busca si ya existe el producto en el carrito
            if (Objects.equals(i.getId_producto(), item.getId_producto())) {
                //Valida si aún puede colocar un item adicional -segun existencias-
                if (i.getCantidad() >1) {
                    //Incrementa en 1 la cantidad de elementos
                    i.setCantidad(i.getCantidad() - 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {//Si no está el producto en el carrito se agrega cantidad =1.            
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    //Se usa para eliminar un producto del carrito
    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getId_producto(), item.getId_producto())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    //Se obtiene la información de un producto del carrito... para modificarlo
    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getId_producto(), item.getId_producto())) {
                return i;
            }
        }
        return null;
    }

    //Se usa en la página para actualizar la cantidad de productos
    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            System.out.println(item);
            if (Objects.equals(i.getId_producto(), item.getId_producto())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Autowired
    private UsuarioService uuarioService;

    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private ProductosDao productoDao;

    @Override
    public void facturar() {
        System.out.println("Facturando");

        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario uuario = uuarioService.getUsuarioPorUsername(username);

        if (uuario == null) {
            return;
        }

        Factura factura = new Factura(uuario.getIdUsuario());
        factura = facturaDao.save(factura);

        double total = 0;
        for (Item i : listaItems) {
            System.out.println("Producto: " + i.getDescripcion_producto()
                    + " Cantidad: " + i.getCantidad()
                    + " Total: " + i.getPrecio_producto()* i.getCantidad());
            Venta venta = new Venta(factura.getIdFactura(), i.getId_producto(), i.getPrecio_producto(), i.getCantidad());
            ventaDao.save(venta);
            Productos producto = productoDao.getReferenceById(i.getId_producto());
            producto.setCantidad_producto(producto.getCantidad_producto()-i.getCantidad());
            productoDao.save(producto);
            total += i.getPrecio_producto() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
    }
}