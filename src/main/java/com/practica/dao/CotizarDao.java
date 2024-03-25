/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.dao;

import com.practica.domain.Cotizar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author esteb
 */
public interface CotizarDao extends JpaRepository<Cotizar, Long> {

   /*public List<Cotizar> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);*/
}
