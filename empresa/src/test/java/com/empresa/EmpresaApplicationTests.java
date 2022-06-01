package com.empresa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.empresa.entity.Empresa;
import com.empresa.service.EmpresaService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmpresaApplicationTests {

	@Autowired
	private EmpresaService empresaService;

	@Test
	void saveTest() {

		Empresa a = new Empresa();

		a.setId_empresa(1);
		a.setId_programa(1);
		a.setNombre("Netflix");

		Empresa guardado = empresaService.save(a);

		assertTrue(guardado.getId_empresa().equals(a.getId_empresa()));
		assertTrue(guardado.getId_programa().equals(a.getId_programa()));
		assertTrue(guardado.getNombre().equals(a.getNombre()));

	}

	@Test
	void readFindAll() {

		Iterable<Empresa> list = empresaService.findAll();

		assertNotNull(list);
	
	}
	
	@Test
	void updateTest() {
	
		 Integer id = 1;
		 Optional<Empresa> a = empresaService.findById(id);

		 Empresa data = new Empresa();
		
		data.setId_empresa(1);
		data.setId_programa(11451551);
		data.setNombre("Disney");
		
		Empresa guardado = empresaService.save(data);
		
		a.get().setId_empresa(data.getId_empresa());
		a.get().setId_programa(data.getId_programa());
		a.get().setNombre(data.getNombre());
		
		assertTrue(guardado.getId_empresa().equals(data.getId_empresa()));
		assertTrue(guardado.getId_programa().equals(data.getId_programa()));				
		assertTrue(guardado.getNombre().equals(data.getNombre()));				

	}

	@Test
	void deleteTest() {
		
		Integer id = 1;
		empresaService.deleteById(id);
		
		Empresa a = empresaService.findById(id).orElse(null);
		
		assertNull(a);				

	}
}
