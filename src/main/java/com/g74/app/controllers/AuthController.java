package com.g74.app.controllers;

import com.g74.app.dao.UsuarioDao;
import com.g74.app.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuariodao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuariodao.verificarCredenciales(usuario)){
            return "Ok";
        }
        return "Fails";
    }
}
