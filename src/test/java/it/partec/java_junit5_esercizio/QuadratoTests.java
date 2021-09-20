package it.partec.java_junit5_esercizio;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import it.partec.java_junit5_esercizio.exception.FiguraException;
import it.partec.java_junit5_esercizio.geometria.Figura;
import it.partec.java_junit5_esercizio.geometria.Quadrato;
import it.partec.java_junit5_esercizio.geometria.Rettangolo;

class QuadratoTests {
	
	@Test
	void newQuadratoTest() {
		assertDoesNotThrow(() -> new Quadrato(4));
	}

	@Test
	void newQuadratoExceptionTest() {
		assertThrows(FiguraException.class, () -> new Quadrato(-3));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 4",
		"2, 8",
		"5, 20"
	})
	void perimetroTest(int base, int perimetro) {
		Quadrato quadrato = new Quadrato(base);
		assertEquals(perimetro, quadrato.getPerimetro());
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 1",
		"3, 9",
		"5, 25"
	})
	void areaTest(int base, int area) {
		Quadrato quadrato = new Quadrato(base);
		assertEquals(area, quadrato.getArea());
	}
	
	@Test
	void equalsTest() {
		Quadrato quadrato1 = new Quadrato(3);
		Quadrato quadrato2 = new Quadrato(3);
		assertTrue(quadrato1.equals(quadrato2));
	}
	
	@Test
	void notEqualsTest() {
		Quadrato quadrato1 = new Quadrato(3);
		Quadrato quadrato2 = new Quadrato(4);
		assertFalse(quadrato1.equals(quadrato2));
	}
	
	@Test
	void equalsObjectTest() {
		Quadrato quadrato1 = new Quadrato(3);
		Object quadrato2 = new Quadrato(3);
		assertTrue(quadrato1.equals(quadrato2));
	}
	
	static Stream<Arguments> getFigure() {
		return Stream.of(
				arguments(new Quadrato(3), new Rettangolo(2, 1), true, 1),
				arguments(new Quadrato(2), new Rettangolo(4, 5), false, -1),
				arguments(new Quadrato(4), new Quadrato(8), false, -1)
				);
	}
	
	@ParameterizedTest
	@MethodSource("getFigure")
	void haPerimetroMaggioreTest(Figura figura1, Figura figura2, boolean b) {
		assertEquals(b, figura1.haPerimetroMaggiore(figura2));
	}
	
	@ParameterizedTest
	@MethodSource("getFigure")
	void haAreaMaggioreTest(Figura figura1, Figura figura2, boolean b) {
		assertEquals(b, figura1.haAreaMaggiore(figura2));
	}
	
	@ParameterizedTest
	@MethodSource("getFigure")
	void compareToTest(Figura figura1, Figura figura2, boolean b, int n) {
		assertEquals(n, figura1.compareTo(figura2));
	}
	
	@Test
	void setLatoTest() {
		Quadrato quadrato = new Quadrato(5);
		quadrato.setLato(3);
		assertEquals(3, quadrato.getBase());
	}
	
	@Test
	void setLatoExceptionTest() {
		Quadrato quadrato = new Quadrato(5);
		assertThrows(FiguraException.class, () -> quadrato.setLato(-3));
	}
}
