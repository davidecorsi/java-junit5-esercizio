package it.partec.java_junit5_esercizio.geometria;

public abstract class Figura implements Comparable<Figura> {

	public abstract double getArea();

	public abstract double getPerimetro();

	public boolean haAreaMaggiore(Figura altra) {
		return this.getArea() > altra.getArea();
	}

	public boolean haPerimetroMaggiore(Figura altra) {
		return this.getPerimetro() > altra.getPerimetro();
	}

	public int compareTo(Figura f) {
		if(this.getArea() > f.getArea()) {
			return 1;
		} else if(this.getArea() < f.getArea()) {
			return -1;
		}
		return 0;
	}
}
