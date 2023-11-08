package es.altair.pruebaSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.altair.pruebaSpring.bean.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
