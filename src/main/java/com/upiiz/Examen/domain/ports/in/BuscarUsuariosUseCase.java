package com.upiiz.Examen.domain.ports.in;

import com.upiiz.Examen.domain.model.Usuario;

import java.util.List;

public interface BuscarUsuariosUseCase {

    List<Usuario> buscar(String texto);
}