package com.empresa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.entity.Empresa;
import com.empresa.repository.EmpresaRespository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRespository empresaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empresa> findAll(Pageable pageable) {
		return empresaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empresa> findById(Integer id_empresa) {
		return empresaRepository.findById(id_empresa);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	@Transactional
	public void deleteById(Integer id_empresa) {
		empresaRepository.deleteById(id_empresa);
	}

}
