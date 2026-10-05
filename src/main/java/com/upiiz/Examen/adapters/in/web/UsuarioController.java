package com.upiiz.Examen.adapters.in.web;

import com.upiiz.Examen.application.dto.UsuarioRequest;
import com.upiiz.Examen.application.dto.UsuarioResponse;
import com.upiiz.Examen.domain.model.Usuario;
import com.upiiz.Examen.domain.ports.in.BuscarUsuariosUseCase;
import com.upiiz.Examen.domain.ports.in.RegistrarUsuarioUseCase;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final BuscarUsuariosUseCase buscarUsuariosUseCase;

    public UsuarioController(
            RegistrarUsuarioUseCase registrarUsuarioUseCase,
            BuscarUsuariosUseCase buscarUsuariosUseCase) {

        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.buscarUsuariosUseCase = buscarUsuariosUseCase;
    }

    @PostMapping
    public ResponseEntity<?> registrar(
            @Valid @RequestBody UsuarioRequest request) {

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setApellidoPaterno(request.getApellidoPaterno());
        usuario.setApellidoMaterno(request.getApellidoMaterno());
        usuario.setCorreo(request.getCorreo());
        usuario.setUsuario(request.getUsuario());
        usuario.setPassword(request.getPassword());
        usuario.setFechaNacimiento(request.getFechaNacimiento());

        registrarUsuarioUseCase.registrar(usuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        Map.of(
                                "mensaje",
                                "Usuario registrado correctamente."
                        )
                );
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioResponse>> buscar(
            @RequestParam String texto) {

        List<UsuarioResponse> resultados =
                buscarUsuariosUseCase.buscar(texto)
                        .stream()
                        .map(UsuarioResponse::fromDomain)
                        .toList();

        return ResponseEntity.ok(resultados);
    }
}