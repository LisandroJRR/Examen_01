package com.upiiz.Examen.domain.ports.in;

import com.upiiz.Examen.domain.model.Usuario;

public interface RegistrarUsuarioUseCase {

    Usuario registrar(Usuario usuario);
}