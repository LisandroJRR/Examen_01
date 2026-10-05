package com.upiiz.Examen.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByCorreo(String correo);

    boolean existsByUsuario(String usuario);

    @Query("""
            SELECT u FROM UsuarioEntity u
            WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :texto, '%'))
               OR LOWER(u.apellidoPaterno) LIKE LOWER(CONCAT('%', :texto, '%'))
               OR LOWER(u.apellidoMaterno) LIKE LOWER(CONCAT('%', :texto, '%'))
               OR LOWER(u.usuario) LIKE LOWER(CONCAT('%', :texto, '%'))
            """)
    List<UsuarioEntity> buscar(@Param("texto") String texto);
}