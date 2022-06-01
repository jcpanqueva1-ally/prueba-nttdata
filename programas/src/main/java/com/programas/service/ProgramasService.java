package com.programas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.programas.entity.Programas;

public interface ProgramasService {

	public Iterable<Programas> findAll();
	
	public Page<Programas> findAll(Pageable pageable);
	
	public Optional<Programas> findById(Integer id_programa);
	
	public Programas save(Programas programas);
	
	public void deleteById(Integer id_programa);
	
}
