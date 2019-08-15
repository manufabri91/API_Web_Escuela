package com.EscuelaU.API_SitioU.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long legajo;
	
	@JsonProperty("nombre")
    @NotBlank
	private String nombre;
	
	@JsonProperty("apellido")
    @NotBlank
	private String apellido;

	@JsonProperty("nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    @NotNull
	private Date nacimiento;
	
	@JsonProperty("dni")
    @NotNull
	private String dni;
	
	@JsonProperty("telefono")
	private String telefono;
	
	//CON ONE TO ONE INDICO LA RELACION
	@OneToOne(cascade = CascadeType.ALL)
	//ESTA ANOTACION INDICA COMO SE REALIZA LA RELACION ENTRE LAS TABLAS
	@PrimaryKeyJoinColumn
	@JsonProperty("telefono")
	@NotNull
	private Usuario usuario;
	
	

	public long getLegajo() {
		return legajo;
	}
	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
