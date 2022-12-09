package com.init.usuario.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@Column(name="usuarioid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="mail" ,nullable = true, length = 60)
	private String mail;
	@Column(name="pass" ,nullable = false, length = 20)
	private String password;
	@Column(name="name",nullable = false, length = 30)
	private String name;
	@Column(name="tlf",nullable = true, length = 30)
	private String phone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
