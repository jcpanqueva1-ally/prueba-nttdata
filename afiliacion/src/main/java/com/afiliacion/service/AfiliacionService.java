package com.afiliacion.service;

import java.util.Optional;


import com.afiliacion.entity.Afiliacion;

public interface AfiliacionService {

	public Iterable<Afiliacion> findAll();
		
	public Optional<Afiliacion> findById(Integer id_afiliacion);
	
	public Afiliacion save(Afiliacion afiliacion);
	
	public void deleteById(Integer id_afiliacion);
	
}
