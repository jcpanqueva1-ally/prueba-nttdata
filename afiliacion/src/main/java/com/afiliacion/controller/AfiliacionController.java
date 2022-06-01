package com.afiliacion.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.afiliacion.entity.Afiliacion;
import com.afiliacion.exception.NotFoundException;
import com.afiliacion.service.AfiliacionService;

@RestController
@RequestMapping("/api/afiliacion")
public class AfiliacionController {

	@Autowired
	private AfiliacionService afiliacionService;

	// Create a new affiliation
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Afiliacion afiliacion) {

		return ResponseEntity.status(HttpStatus.CREATED).body(afiliacionService.save(afiliacion));
	}

	// read affiliation
	@GetMapping("/{id_afiliacion}")
	public ResponseEntity<?> read(@PathVariable(value = "id_afiliacion") Integer id_afiliacion) {

		Optional<Afiliacion> oAfiliacion = afiliacionService.findById(id_afiliacion);

		if (!oAfiliacion.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		return ResponseEntity.ok(oAfiliacion);
	}

	// update an affiliation
	@PutMapping("/{id_afiliacion}")
	public ResponseEntity<?> update(@RequestBody Afiliacion afiliacionDetalle, @PathVariable(value = "id_afiliacion") Integer id_afiliacion) {
		Optional<Afiliacion> afiliacion = afiliacionService.findById(id_afiliacion);

		if (!afiliacion.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		afiliacion.get().setId_afiliacion(afiliacionDetalle.getId_afiliacion());
		afiliacion.get().setDoc_cliente(afiliacionDetalle.getDoc_cliente());
		afiliacion.get().setPrograma(afiliacionDetalle.getPrograma());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(afiliacionService.save(afiliacion.get()));
		
	}
	
	//delete an affiliation
	@DeleteMapping("/{id_afiliacion}")
	public ResponseEntity<?> delete (@PathVariable(value = "id_afiliacion") Integer id_afiliacion){
		
		if(!afiliacionService.findById(id_afiliacion).isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}
		
		afiliacionService.deleteById(id_afiliacion);
		return ResponseEntity.ok().build(); 
		
	}

	//Read all affiliations
	@GetMapping
	public List<Afiliacion> readAll(){
		
		List<Afiliacion> afiliacion = StreamSupport
				.stream(afiliacionService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return afiliacion;
	}
}
