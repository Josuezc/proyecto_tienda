/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Cotizar;
import com.practica.service.CotizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author esteb
 */
@Controller
@RequestMapping("/Cotizar")
public class CotizarController {

    @Autowired
    private CotizarService cotizarService;

    @GetMapping("/servicio")
    public String cotizarServicio() {
        return "Cotizar/servicio";
    }

    @GetMapping("/completado")
    public String cotizarCompletado() {

        return "Cotizar/completado";
    }
 /*@PostMapping("/login")
    public String validarLogin(@ModelAttribute("cotizar") Cotizar cotizar, Model model) {

        Cotizar cotizarAutenticado = cotizarService.getCategoria(cotizar);

        if (cotizarAutenticado != null) {
            // Cotizar autenticado, redirige a la página deseada
            return "redirect:/Usuarios/listado";
        } else {
            // Cotizar no autenticado, vuelve al formulario de inicio con un mensaje de error
            model.addAttribute("error", "Credenciales inválidas");
            return "Usuarios/inicio";
        }*/
    @PostMapping("/enviar")
    public String cotizarEnviar() {
        return "/Cotizar/completado";
    }

}
