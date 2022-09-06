package com.g74.app.controllers;

import com.g74.app.dao.UsuarioDao;
import com.g74.app.models.Usuario;
import com.g74.app.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuariodao;

    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado = usuariodao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado != null){
            String tokenJwt = jwtutil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            return tokenJwt;
        }
        return "Error in login process";
    }
}
