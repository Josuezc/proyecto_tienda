/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.service.UsuarioService;
import com.practica.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



 @Controller
@RequestMapping("/adminUsuario")
public class AdminUsuarioController {
  
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listado")
private String listado(Model model) {
      
    var usuarios = usuarioService.getUsuariosActivos(false);
    model.addAttribute("usuarios", usuarios);
    model.addAttribute("totalUsuarios", usuarios.size());
    return "/adminUsuario/listado";
   
}
    
    
     @GetMapping("/nuevo")
    public String categoriaNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

  
   @PostMapping("/guardar")
    public String categoriaGuardar(Usuario usuario){
            
            usuarioService.save(usuario);
        
        return "redirect:/adminUsuario/listado";
    }

    @PostMapping("/guardarIf")
    public String guardarUsuarioConValidacion(@ModelAttribute("adminUsuario") Usuario usuario, Model model) {
        if (usuarioService.existsByCedulaUsuario(usuario.getCedula_usuario())) {
           
            model.addAttribute("error", "La cédula de usuario ya existe.");
            return "/adminUsuario/listado";
        }
        usuarioService.save(usuario);
        return "redirect:/adminUsuario/listado";
    }
    
    
 
    
    
    @GetMapping("/eliminar/{cedula_usuario}")
    public String categoriaEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/adminUsuario/listado";
    }

    @GetMapping("/modifica/{cedula_usuario}")
    public String categoriaModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getCategoria(usuario);
        model.addAttribute("usuario", usuario);
        return "adminUsuario/modifica";
    }
    


 
   

}
