package com.g74.app.controllers;

import com.g74.app.dao.UsuarioDao;
import com.g74.app.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class UserController {
    //hace que la clase usuariodao cre un objeto y lo guarde ahí
    @Autowired
    private UsuarioDao usuariodao;
    private EntityManager entityManager;


    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
        public Usuario getUsuario(@PathVariable long id){

        return getUsuario( id );
    }


    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuariodao.getUsuarios();
    }

    @RequestMapping(value = "api/registrar", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String passHash = argon2.hash(1, 1024, 1, usuario.getContraseña());
        usuario.setContraseña(passHash);
        usuariodao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable long id){
        usuariodao.eliminar(id);
    }



}
