package com.afiliacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Afiliacion")
public class Afiliacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_afiliacion;

	@Column(columnDefinition = "integer default 10")
	private Integer doc_cliente;
	
	@Column(length = 45)
	private String programa;

	public Integer getId_afiliacion() {
		return id_afiliacion;
	}

	public void setId_afiliacion(Integer id_afiliacion) {
		this.id_afiliacion = id_afiliacion;
	}

	public Integer getDoc_cliente() {
		return doc_cliente;
	}

	public void setDoc_cliente(Integer doc_cliente) {
		this.doc_cliente = doc_cliente;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
