package it.partec.java_junit5_esercizio.geometria;

public class Quadrato extends Rettangolo {

	public Quadrato(double lato) {
		super(lato, lato);
	}
	
	public double getLato() {
		return getBase();
	}
	
	public void setLato(double lato) {
		setBase(lato);
		setAltezza(lato);
	}
	
	public String toString() {
		return "lato = " + getLato();
	}
	
	public void setBase(double lato) {
		super.setBase(lato);
	}

	public void setAltezza(double lato) {
		super.setAltezza(lato);
	}
}
