package com.gestionstock.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	public void suma() {
		int resultado = 2 + 6;
		assertEquals(8, resultado, "El resultado deberia ser 8");
	// System.out.println("El resultado es: " + resultado);
	}

}
