package com.cliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.entity.Cliente;
import com.cliente.repository.ClienteRespository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRespository clienteRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Integer doc_cliente) {
		return clienteRepository.findById(doc_cliente);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Integer doc_cliente) {
		clienteRepository.deleteById(doc_cliente);
	}

}
