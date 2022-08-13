package com.g74.app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    //maven lombok se utilizo para optimizar los getters y los setters
    @Id
    @Getter @Setter @Column(name = "id_usuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_usuario;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellidos")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "contraseña")
    private String contraseña;

    public Usuario(String nombre, String apellido, String email, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario() {

    }
}
