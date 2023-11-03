package es.altair.pruebaSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.altair.pruebaSpring.bean.Acceso;


public interface AccesoRepository extends JpaRepository<Acceso, Long> {}