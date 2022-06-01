package com.cliente.controller;

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

import com.cliente.entity.Cliente;
import com.cliente.exception.NotFoundException;
import com.cliente.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// Create a new client
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	// read client
	@GetMapping("/{doc_cliente}")
	public ResponseEntity<?> read(@PathVariable(value = "doc_cliente") Integer doc_cliente) {

		Optional<Cliente> oCliente = clienteService.findById(doc_cliente);

		if (!oCliente.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		return ResponseEntity.ok(oCliente);
	}

	// update an client
	@PutMapping("/{doc_cliente}")
	public ResponseEntity<?> update(@RequestBody Cliente clienteDetalle, @PathVariable(value = "doc_cliente") Integer doc_cliente) {
		Optional<Cliente> cliente = clienteService.findById(doc_cliente);

		if (!cliente.isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		cliente.get().setNombre(clienteDetalle.getNombre());
		cliente.get().setDoc_cliente(clienteDetalle.getDoc_cliente());
		cliente.get().setId_cliente(clienteDetalle.getId_cliente());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
		
	}
	
	//delete an Client
	@DeleteMapping("/{doc_cliente}")
	public ResponseEntity<?> delete (@PathVariable(value = "doc_cliente") Integer doc_cliente){
		
		if(!clienteService.findById(doc_cliente).isPresent()) {
			throw new NotFoundException("No se encontraron resultados");
		}
		
		clienteService.deleteById(doc_cliente);
		return ResponseEntity.ok().build(); 
		
	}

}
