/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.service.ClienteService;
import com.practica.domain.Cliente;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import org.hibernate.boot.model.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



 @Controller
@RequestMapping("/adminCliente")
public class ClienteController {
  
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/listado")
private String listado(Model model) {
      
    var clientes = clienteService.getClientesActivos(false);
    model.addAttribute("clientes", clientes);
    model.addAttribute("totalClientes", clientes.size());
    return "/adminCliente/listado";
   
}
    
    
     @GetMapping("/nuevo")
    public String categoriaNuevo(Cliente cliente) {
        return "/cliente/modifica";
    }

    //@Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
   @PostMapping("/guardar")
    public String categoriaGuardar(Cliente cliente){
            
            clienteService.save(cliente);
        
        return "redirect:/adminCliente/listado";
    }
//valida que no exista un usuario con la misma (cedula o id)
    @PostMapping("/guardarIf")
    public String guardarClienteConValidacion(@ModelAttribute("cliente") Cliente cliente, Model model) {
        if (clienteService.existsByCedulaUsuario(cliente.getCedula_usuario())) {
           
            model.addAttribute("error", "La cédula de usuario ya existe.");
            return "/adminCliente/listado";
        }
        clienteService.save(cliente);
        return "redirect:/adminCliente/listado";
    }
    
    
 
    
    
    @GetMapping("/eliminar/{cedula_usuario}")
    public String categoriaEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/adminCliente/listado";
    }

    @GetMapping("/modifica/{cedula_usuario}")
    public String categoriaModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCategoria(cliente);
        model.addAttribute("cliente", cliente);
        return "/adminCliente/modifica";
    }
    


 
   

}
