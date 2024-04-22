package com.practica.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")

public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id_rol")
    private Long id_rol;
    private String nombre;
    @Column (name = "id_usuario")
    private Long id_usuario;    
}
