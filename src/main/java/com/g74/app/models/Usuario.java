package com.g74.app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    //maven lombok se utilizo para optimizar los getters y los setters
    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "contraseña")
    private String contraseña;

    public Usuario(long id, String nombre, String email, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario(String email, String nombre, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public Usuario() {

    }
}
