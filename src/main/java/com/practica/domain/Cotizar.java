/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author esteb
 */
@Data
@Entity
@Table(name = "cotizar")

public class Cotizar implements Serializable {

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "nombre_cliente") //decir cual es el nombre en la base de datos. Se hace la asociación 

    private long nombre_cliente;
    private String apellido_cliente;
    private String correo_cliente;
    private String telefono_cliente;
    private String descripcion;
    

    public Cotizar() {
    }

    public Cotizar(long nombre_cliente, String apellido_cliente, String correo_cliente, String telefono_cliente, String descripcion) {
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.correo_cliente = correo_cliente;
        this.telefono_cliente = telefono_cliente;
        this.descripcion = descripcion;
    }       

}
