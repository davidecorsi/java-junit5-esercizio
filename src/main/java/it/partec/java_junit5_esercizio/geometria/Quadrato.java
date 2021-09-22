package it.partec.java_junit5_esercizio.geometria;

public class Quadrato extends Rettangolo {

	public Quadrato(double lato) {
		super(lato, lato);
	}

	public double getLato() {
		return getBase();
	}

	public void setLato(double lato) {
		super.setBase(lato);
		super.setAltezza(lato);
	}

	public String toString() {
		return "lato = " + getLato();
	}

	public void setBase(double lato) {
		setLato(lato);
	}

	public void setAltezza(double lato) {
		setLato(lato);
	}
}
