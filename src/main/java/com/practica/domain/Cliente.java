/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.domain;



import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "clientes")

public class Cliente implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "cedula_usuario") //decir cual es el nombre en la base de datos. Se hace la asociación 
    
  
    private long cedula_usuario;
    private String nombre_cliente;
    private String apellido_cliente;
    private String correo_cliente;
    private String contrasena_cliente;

    public Cliente(String contrasena_cliente) {
        this.contrasena_cliente = contrasena_cliente;
    }
    private String direccion_cliente;
    private boolean activo;
   

    public Cliente() {
    }

    public Cliente(long cedula_usuario, boolean activo) {
        this.cedula_usuario = cedula_usuario;
     
        this.activo = activo;
    }

   

   

}
