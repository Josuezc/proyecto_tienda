package com.practica.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")

public class Categorias implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_categoria") //decir cual es el nombre en la base de datos. Se hace la asociación 

    private long id_categoria;
    private String nombre_categoria;
    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    List<Productos> productos;

    public Categorias() {
    }

    public Categorias(long id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

}
