package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cliente.entity.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {

}
