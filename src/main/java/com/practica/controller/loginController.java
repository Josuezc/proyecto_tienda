/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Cliente;
import com.practica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexa
 */
@Controller
@RequestMapping("/Usuarios")
public class loginController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "Usuarios/inicio";
    }
    @GetMapping("/registro")
    public String showRegistroPage() {
       
        return "Usuarios/listado"; 
    }


       @PostMapping("/login")
    public String validarLogin(@ModelAttribute("cliente") Cliente cliente, Model model) {
        
            Cliente clienteAutenticado = clienteService.getCategoria(cliente);

            if (clienteAutenticado != null) {
                // Cliente autenticado, redirige a la página deseada
                return "redirect:/Usuarios/listado";
            } else {
                // Cliente no autenticado, vuelve al formulario de inicio con un mensaje de error
                model.addAttribute("error", "Credenciales inválidas");
                return "Usuarios/inicio";
            }
       
       
            
        
    }
    
     @PostMapping("/guardarIf")
    public String guardarClienteConValidacion(@ModelAttribute("cliente") Cliente cliente, Model model) {
        if (clienteService.existsByCedulaUsuario(cliente.getCedula_usuario())) {
           
            model.addAttribute("error", "La cédula de usuario ya existe.");
            return "/Usuarios/registro";
        }
        clienteService.save(cliente);
        return "redirect:/Usuarios/registro";
    }
}
