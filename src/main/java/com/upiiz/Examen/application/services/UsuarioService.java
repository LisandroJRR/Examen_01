package com.upiiz.Examen.application.services;

import com.upiiz.Examen.domain.model.Usuario;
import com.upiiz.Examen.domain.ports.in.BuscarUsuariosUseCase;
import com.upiiz.Examen.domain.ports.in.RegistrarUsuarioUseCase;
import com.upiiz.Examen.domain.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements RegistrarUsuarioUseCase, BuscarUsuariosUseCase {

    private final UsuarioRepositoryPort repository;

    public UsuarioService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Usuario registrar(Usuario usuario) {

        if (repository.existePorCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException(
                    "El correo electrónico ya está registrado."
            );
        }

        if (repository.existePorUsuario(usuario.getUsuario())) {
            throw new IllegalArgumentException(
                    "El nombre de usuario ya está registrado."
            );
        }

        return repository.guardar(usuario);
    }

    @Override
    public List<Usuario> buscar(String texto) {

        if (texto == null || texto.trim().length() < 3) {
            throw new IllegalArgumentException(
                    "La búsqueda debe contener al menos 3 caracteres."
            );
        }

        return repository.buscar(texto.trim());
    }
}