package com.g74.app.controllers;

import com.g74.app.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @RequestMapping(value = "usuario/{id}")
        public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Sebas");
        usuario.setApellido("Amaya");
        usuario.setEmail("sebasjuve@gmail.com");
        usuario.setTelefono("3227191362");
        usuario.setPassword("Chamila");
        return usuario;
    }

    @RequestMapping(value = "usuario")
    public Usuario editarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Sebas");
        usuario.setApellido("Amaya");
        usuario.setEmail("sebasjuve@gmail.com");
        usuario.setTelefono("3227191362");
        usuario.setPassword("Chamila");
        return usuario;
    }
}
