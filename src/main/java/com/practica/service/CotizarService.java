/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Cotizar;
import java.util.List;

/**
 *
 * @author esteb
 */
public interface CotizarService {

    // Se obtiene un listado de cotizars en un List
    public List<Cotizar> getCotizars();
    
    
    // Se obtiene un Cotizar, a partir del id de un cotizar
    public Cotizar getCotizar( Cotizar cotizar);

    // Se inserta un nuevo cotizar si el id del cotizar esta vacío     
    // Se actualiza un cotizar si el id del cotizar NO esta vacío     
    public void save(Cotizar cotizar);

    // Se elimina el cotizar que tiene el id pasado por parámetro     
    public void delete(Cotizar cotizar);

}
