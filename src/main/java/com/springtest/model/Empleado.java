package com.springtest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "empleados")
@EntityListeners(AuditingEntityListener.class)
public class Empleado {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 
 @NotBlank
 private String nombre;

 @NotBlank
 private String asignacion;

 @NotBlank
 private String habilidad;

 @Temporal(TemporalType.TIMESTAMP)
 @LastModifiedDate
 private Date creadoEn;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getAsignacion() {
	return asignacion;
}

public void setAsignacion(String asignacion) {
	this.asignacion = asignacion;
}

public String getHabilidad() {
	return habilidad;
}

public void setHabilidad(String habilidad) {
	this.habilidad = habilidad;
}

public Date getCreadoEn() {
	return creadoEn;
}

public void setCreadoEn(Date creadoEn) {
	this.creadoEn = creadoEn;
}
 
 
 
}
