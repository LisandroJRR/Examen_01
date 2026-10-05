package com.upiiz.Examen.adapters.out.persistence;

import com.upiiz.Examen.domain.model.Usuario;
import com.upiiz.Examen.domain.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repository;

    public UsuarioPersistenceAdapter(UsuarioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        UsuarioEntity entity = new UsuarioEntity();

        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombre());
        entity.setApellidoPaterno(usuario.getApellidoPaterno());
        entity.setApellidoMaterno(usuario.getApellidoMaterno());
        entity.setCorreo(usuario.getCorreo());
        entity.setUsuario(usuario.getUsuario());
        entity.setPassword(usuario.getPassword());
        entity.setFechaNacimiento(usuario.getFechaNacimiento());

        UsuarioEntity guardado = repository.save(entity);

        usuario.setId(guardado.getId());

        return usuario;
    }

    @Override
    public boolean existePorCorreo(String correo) {
        return repository.existsByCorreo(correo);
    }

    @Override
    public boolean existePorUsuario(String usuario) {
        return repository.existsByUsuario(usuario);
    }

    @Override
    public List<Usuario> buscar(String texto) {

        return repository.buscar(texto)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private Usuario toDomain(UsuarioEntity entity) {

        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getApellidoPaterno(),
                entity.getApellidoMaterno(),
                entity.getCorreo(),
                entity.getUsuario(),
                entity.getPassword(),
                entity.getFechaNacimiento()
        );
    }
}