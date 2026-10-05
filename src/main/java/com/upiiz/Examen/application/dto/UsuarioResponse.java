package com.upiiz.Examen.application.dto;

import com.upiiz.Examen.domain.model.Usuario;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String nombre, String apellidoPaterno,
                           String apellidoMaterno, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
    }

    public static UsuarioResponse fromDomain(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getUsuario()
        );
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getUsuario() {
        return usuario;
    }
}