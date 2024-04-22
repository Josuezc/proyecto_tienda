/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;    
    private boolean activo;
    public Usuario() {
    }
    @OneToMany
    @JoinColumn(name="id_usuario")
    List<Rol> roles;

    public Usuario(long idUsuario, boolean activo) {
        this.idUsuario = idUsuario;

        this.activo = activo;
    }

}
