package com.afiliacion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afiliacion.entity.Afiliacion;
import com.afiliacion.repository.AfiliacionRespository;

@Service
public class AfiliacionServiceImpl implements AfiliacionService {

	@Autowired
	private AfiliacionRespository afiliacionRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Afiliacion> findAll() {
		return afiliacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Afiliacion> findById(Integer id_afiliacion) {
		return afiliacionRepository.findById(id_afiliacion);
	}

	@Override
	@Transactional
	public Afiliacion save(Afiliacion afiliacion) {
		return afiliacionRepository.save(afiliacion);
	}

	@Override
	@Transactional
	public void deleteById(Integer id_afiliacion) {
		afiliacionRepository.deleteById(id_afiliacion);
	}

}
