/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.dao;

import com.practica.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexa
 */
public interface VentaDao extends JpaRepository <Venta, Long> {
    
}
