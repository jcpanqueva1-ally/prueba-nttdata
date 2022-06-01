package com.empresa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empresa;
import com.empresa.exception.NotFoundException;
import com.empresa.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	// Create a new empresa
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Empresa empresa) {

		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));
	}

	// read empresa
	@GetMapping("/{id_empresa}")
	public ResponseEntity<?> read(@PathVariable(value = "id_empresa") Integer id_empresa) {

		Optional<Empresa> oEmpresa = empresaService.findById(id_empresa);

		if (!oEmpresa.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		return ResponseEntity.ok(oEmpresa);
	}

	// update an empresa
	@PutMapping("/{id_empresa}")
	public ResponseEntity<?> update(@RequestBody Empresa empresaDetalle, @PathVariable(value = "id_empresa") Integer id_empresa) {
		Optional<Empresa> empresa = empresaService.findById(id_empresa);

		if (!empresa.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		empresa.get().setId_empresa(empresaDetalle.getId_empresa());
		empresa.get().setId_programa(empresaDetalle.getId_programa());		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa.get()));
		
	}
	
	//delete an Client
	@DeleteMapping("/{id_empresa}")
	public ResponseEntity<?> delete (@PathVariable(value = "id_empresa") Integer id_empresa){
		
		if(!empresaService.findById(id_empresa).isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}
		
		empresaService.deleteById(id_empresa);
		return ResponseEntity.ok().build(); 
		
	}

}
