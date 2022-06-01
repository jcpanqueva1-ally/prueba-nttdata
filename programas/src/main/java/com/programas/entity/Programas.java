package com.programas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Programas")
public class Programas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_programa;
	
	@Column(length = 45)
	private String programa;

	public Integer getId_programa() {
		return id_programa;
	}

	public void setId_programa(Integer id_programa) {
		this.id_programa = id_programa;
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
