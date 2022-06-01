package com.cliente.service;

import java.util.Optional;

import com.cliente.entity.Cliente;

public interface ClienteService {

	public Iterable<Cliente> findAll();
		
	public Optional<Cliente> findById(Integer doc_cliente);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Integer doc_cliente);
	
}
