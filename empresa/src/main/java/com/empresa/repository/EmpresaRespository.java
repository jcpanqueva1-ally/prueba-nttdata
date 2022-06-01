package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.entity.Empresa;

@Repository
public interface EmpresaRespository extends JpaRepository<Empresa, Integer> {

}
