/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author alexa
 */
@Data
@Entity
@Table(name = "productos")

public class Productos implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_producto") //decir cual es el nombre en la base de datos. Se hace la asociación 

    private long id_producto;
    private String nombre_producto;
    private double precio_producto;
    private int cantidad_producto;
    private String imagenfile;   
    private String descripcion_producto;
    //private long id_categoria;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categorias id_categoria;

    public Productos() {
    }

    public Productos(long id_producto, String nombre_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
    }

}
