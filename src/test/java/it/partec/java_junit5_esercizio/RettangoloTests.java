package it.partec.java_junit5_esercizio;

import static org.junit.jupiter.api.Assertions.*;

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
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RettangoloTests {

	@Test
	void newRettangoloTest() {
		assertDoesNotThrow(() -> new Rettangolo(1,4));
	}

	@Test
	void newRettangoloExceptionTest() {
		assertThrows(FiguraException.class, () -> new Rettangolo(-1, 5));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 3, 8",
		"2, 5, 14",
		"5, 6, 22"
	})
	void perimetroTest(int base, int altezza, int perimetro) {
		Rettangolo rettangolo = new Rettangolo(base, altezza);
		assertEquals(perimetro, rettangolo.getPerimetro());
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 2, 2",
		"3, 4, 12",
		"5, 6, 30"
	})
	void areaTest(int base, int altezza, int area) {
		Rettangolo rettangolo = new Rettangolo(base, altezza);
		assertEquals(area, rettangolo.getArea());
	}
	
	@Test
	void equalsTest() {
		Rettangolo rettangolo1 = new Rettangolo(3, 5);
		Rettangolo rettangolo2 = new Rettangolo(3, 5);
		assertTrue(rettangolo1.equals(rettangolo2));
	}
	
	@Test
	void notEqualsTest() {
		Rettangolo rettangolo1 = new Rettangolo(3, 5);
		Rettangolo rettangolo2 = new Rettangolo(4, 6);
		assertFalse(rettangolo1.equals(rettangolo2));
	}
	
	@Test
	void equalsObjectTest() {
		Rettangolo rettangolo1 = new Rettangolo(3, 5);
		Object rettangolo2 = new Rettangolo(3, 5);
		assertTrue(rettangolo1.equals(rettangolo2));
	}
	
	static Stream<Arguments> getFigure() {
		return Stream.of(
				arguments(new Rettangolo(3, 4), new Quadrato(2), true, 1),
				arguments(new Rettangolo(2, 2), new Rettangolo(4, 5), false, -1),
				arguments(new Rettangolo(4, 5), new Quadrato(8), false, -1)
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
}
