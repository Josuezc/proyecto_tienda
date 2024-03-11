/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.dao;

import com.practica.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexa
 */

 public interface ProductosDao extends JpaRepository <Productos,Long> {
}
