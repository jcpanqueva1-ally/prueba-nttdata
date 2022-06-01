package com.programas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programas.entity.Programas;
import com.programas.repository.ProgramasRespository;

@Service
public class ProgramasServiceImpl implements ProgramasService {

	@Autowired
	private ProgramasRespository programasRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Programas> findAll() {
		return programasRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Programas> findAll(Pageable pageable) {
		return programasRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Programas> findById(Integer id_programa) {
		return programasRepository.findById(id_programa);
	}

	@Override
	@Transactional
	public Programas save(Programas programas) {
		return programasRepository.save(programas);
	}

	@Override
	@Transactional
	public void deleteById(Integer id_programa) {
		programasRepository.deleteById(id_programa);
	}

}
