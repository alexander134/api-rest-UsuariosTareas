package com.init.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.usuario.entitys.Usuario;

public interface UsuariosDAO extends JpaRepository<Usuario, Long> {

}
