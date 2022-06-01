package com.programas.controller;

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

import com.programas.entity.Programas;
import com.programas.exception.NotFoundException;
import com.programas.service.ProgramasService;

@RestController
@RequestMapping("/api/programas")
public class ProgramasController {

	@Autowired
	private ProgramasService programasService;

	// Create a new client
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Programas programas) {

		return ResponseEntity.status(HttpStatus.CREATED).body(programasService.save(programas));
	}

	// read client
	@GetMapping("/{id_programa}")
	public ResponseEntity<?> read(@PathVariable(value = "id_programa") Integer id_programa) {

		Optional<Programas> oProgramas = programasService.findById(id_programa);

		if (!oProgramas.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		return ResponseEntity.ok(oProgramas);
	}

	// update an client
	@PutMapping("/{id_programa}")
	public ResponseEntity<?> update(@RequestBody Programas programasDetalle, @PathVariable(value = "id_programa") Integer id_programa) {
		Optional<Programas> programas = programasService.findById(id_programa);

		if (!programas.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		programas.get().setId_programa(programasDetalle.getId_programa());
		programas.get().setPrograma(programasDetalle.getPrograma());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(programasService.save(programas.get()));
		
	}
	
	//delete an Client
	@DeleteMapping("/{id_programa}")
	public ResponseEntity<?> delete (@PathVariable(value = "id_programa") Integer id_programa){
		
		if(!programasService.findById(id_programa).isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}
		
		programasService.deleteById(id_programa);
		return ResponseEntity.ok().build(); 
		
	}

}
