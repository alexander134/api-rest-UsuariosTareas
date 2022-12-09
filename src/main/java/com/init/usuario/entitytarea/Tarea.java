package com.init.usuario.entitytarea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarea")
public class Tarea {
	@Id
	@Column(name="tareaid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTarea;
	
	@Column(name="idusuario")
	private long idUsuario;
	@Column(name="name" ,nullable = false, length = 60)
	private String name;
	@Column(name="descripcion" ,nullable = false, length = 60)
	private String descripcion;
	
	
	public long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
