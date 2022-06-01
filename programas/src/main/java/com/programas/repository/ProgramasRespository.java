package com.programas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programas.entity.Programas;

@Repository
public interface ProgramasRespository extends JpaRepository<Programas, Integer> {

}
