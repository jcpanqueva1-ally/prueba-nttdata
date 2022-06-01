package com.afiliacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afiliacion.entity.Afiliacion;

@Repository
public interface AfiliacionRespository extends JpaRepository<Afiliacion, Integer> {

}
