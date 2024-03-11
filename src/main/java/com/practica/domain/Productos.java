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
        private String precio_producto;
        private String cantidad_producto;
        private String imagen_producto;
        private String id_categoria;

        public Productos() {
        }

        public Productos(long id_producto, String nombre_producto) {
            this.id_producto = id_producto;
            this.nombre_producto = nombre_producto;
        }

       
       

    }

