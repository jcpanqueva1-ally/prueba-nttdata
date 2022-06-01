package com.afiliacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import com.afiliacion.entity.Afiliacion;
import com.afiliacion.service.AfiliacionService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AfiliacionApplicationTests {

	@Autowired
	private AfiliacionService afiliacionService;
	
	@Test
	void saveTest() {
		
		Afiliacion a = new Afiliacion();
		
		a.setId_afiliacion(1);
		a.setDoc_cliente(122225552);
		a.setPrograma("Disney Plus");
		
		Afiliacion guardado = afiliacionService.save(a);
		
		assertTrue(guardado.getId_afiliacion().equals(a.getId_afiliacion()));
		assertTrue(guardado.getDoc_cliente().equals(a.getDoc_cliente()));
		assertTrue(guardado.getPrograma().equals(a.getPrograma()));

	}
	
	@Test
	void readFindAllTest() {
		
		Iterable<Afiliacion> list = afiliacionService.findAll();
		
		assertNotNull(list);
		
	}

	@Test
	void updateTest() {
	
		 Integer id = 1;
		 Optional<Afiliacion> a = afiliacionService.findById(id);

		Afiliacion data = new Afiliacion();
		
		data.setId_afiliacion(1);
		data.setDoc_cliente(11451551);
		
		Afiliacion guardado = afiliacionService.save(data);
		
		a.get().setId_afiliacion(data.getId_afiliacion());
		a.get().setDoc_cliente(data.getDoc_cliente());
		a.get().setPrograma(data.getPrograma());
		
		assertTrue(guardado.getId_afiliacion().equals(data.getId_afiliacion()));	
		assertTrue(guardado.getDoc_cliente().equals(data.getDoc_cliente()));				
		assertTrue(guardado.getPrograma().equals(data.getPrograma()));				

	}
	
	@Test
	void deleteTest() {
	
		Integer id = 1;
		afiliacionService.deleteById(id);
		
		Afiliacion a = afiliacionService.findById(id).orElse(null);
		
		assertNull(a);				

	}
}
