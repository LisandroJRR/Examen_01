package com.upiiz.Examen.domain.ports.out;

import com.upiiz.Examen.domain.model.Usuario;

import java.util.List;

public interface UsuarioRepositoryPort {

    Usuario guardar(Usuario usuario);

    boolean existePorCorreo(String correo);

    boolean existePorUsuario(String usuario);

    List<Usuario> buscar(String texto);
}