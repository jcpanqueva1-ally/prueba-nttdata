package com.cliente;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cliente.entity.Cliente;
import com.cliente.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteApplicationTests {

	@Autowired
	private ClienteService clienteService;

	@Test
	void saveTest() {

		Cliente a = new Cliente();

		a.setId_cliente(1);
		a.setDoc_cliente(122225552);
		a.setNombre("Pepito Perez");

		Cliente guardado = clienteService.save(a);

		assertTrue(guardado.getId_cliente().equals(a.getId_cliente()));
		assertTrue(guardado.getDoc_cliente().equals(a.getDoc_cliente()));
		assertTrue(guardado.getNombre().equals(a.getNombre()));

	}

	@Test
	void readFindAllTest() {

		Iterable<Cliente> list = clienteService.findAll();

		assertNotNull(list);

	}

	@Test
	void updateTest() {

		Integer id = 1;
		Optional<Cliente> a = clienteService.findById(id);

		Cliente data = new Cliente();

		data.setId_cliente(1);
		data.setDoc_cliente(122225552);
		data.setNombre("Pepito Perez");

		Cliente guardado = clienteService.save(data);

		a.get().setId_cliente(data.getId_cliente());
		a.get().setDoc_cliente(data.getDoc_cliente());
		a.get().setNombre(data.getNombre());

		assertTrue(guardado.getId_cliente().equals(data.getId_cliente()));
		assertTrue(guardado.getDoc_cliente().equals(data.getDoc_cliente()));
		assertTrue(guardado.getNombre().equals(data.getNombre()));

	}

	@Test
	void deleteTest() {

		Integer id = 1;

		clienteService.deleteById(id);

		Cliente a = clienteService.findById(id).orElse(null);

		assertNull(a);

	}
}
