package com.programas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.programas.entity.Programas;
import com.programas.service.ProgramasService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProgramasApplicationTests {

	@Autowired
	private ProgramasService programasService;
	
	@Test
	void saveTest() {
		
		Programas a = new Programas();
		
		a.setId_programa(1);
		a.setPrograma("Disney Plus");
		
		Programas guardado = programasService.save(a);
		
		assertTrue(guardado.getId_programa().equals(a.getId_programa()));
		assertTrue(guardado.getPrograma().equals(a.getPrograma()));

	}
	
	@Test
	void readFindAllTest() {
		
		Iterable<Programas> list = programasService.findAll();
		
		assertNotNull(list);
		
	}

	@Test
	void updateTest() {
	
		 Integer id = 1;
		 Optional<Programas> a = programasService.findById(id);

		 Programas data = new Programas();
		
		data.setId_programa(1);
		data.setPrograma("youtube Premium");
		
		Programas guardado = programasService.save(data);
		
		a.get().setId_programa(data.getId_programa());
		a.get().setPrograma(data.getPrograma());
		
		assertTrue(guardado.getId_programa().equals(data.getId_programa()));	
		assertTrue(guardado.getPrograma().equals(data.getPrograma()));				

	}
	
	@Test
	void deleteTest() {
	
		Integer id = 1;
		
		programasService.deleteById(id);
		
		Programas a = programasService.findById(id).orElse(null);
		
		assertNull(a);				

	}
}