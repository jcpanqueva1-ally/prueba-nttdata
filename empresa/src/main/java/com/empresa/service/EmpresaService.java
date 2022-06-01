package com.empresa.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.empresa.entity.Empresa;

public interface EmpresaService {

	public Iterable<Empresa> findAll();
	
	public Page<Empresa> findAll(Pageable pageable);
	
	public Optional<Empresa> findById(Integer id_empresa);
	
	public Empresa save(Empresa empresa);
	
	public void deleteById(Integer id_empresa);
	
}
