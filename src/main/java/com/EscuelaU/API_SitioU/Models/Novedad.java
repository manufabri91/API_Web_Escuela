package com.EscuelaU.API_SitioU.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Novedad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_novedad;
	
	@JsonProperty("titulo")
    @NotBlank
	private String titulo;
	
	@JsonProperty("cuerpo")
    @NotBlank
	private String cuerpo;
	
	@JsonProperty("resumen")
    @NotBlank
    @Lob
	private String resumen;

	@JsonProperty("importante")
	private boolean importante;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}


	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public boolean isImportante() {
		return importante;
	}

	public void setImportante(boolean importante) {
		this.importante = importante;
	}

	public long getId_novedad() {
		return id_novedad;
	}
	
		
	
	
}
