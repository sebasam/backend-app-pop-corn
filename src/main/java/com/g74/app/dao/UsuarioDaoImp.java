package com.g74.app.dao;

import com.g74.app.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
//accede al repo de la database
@Repository
//funcionalidad a esta clase para hacer consultas a la base de datos
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
       String query = "FROM Usuario";
      List<Usuario> resultado =  entityManager.createQuery(query).getResultList();
      return resultado;
    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Boolean verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email AND contraseña = :contraseña";
        List<Usuario> lista = entityManager.createQuery((query))
                .setParameter("email", usuario.getEmail())
                .setParameter("contraseña", usuario.getContraseña())
                .getResultList();

        return !lista.isEmpty();
    }

}
