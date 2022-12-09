package com.init.usuario.daotarea;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.usuario.entitytarea.Tarea;

public interface TareaDAO extends JpaRepository<Tarea, Long> {

}
