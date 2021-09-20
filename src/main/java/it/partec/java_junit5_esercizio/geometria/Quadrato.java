package it.partec.java_junit5_esercizio.geometria;

import it.partec.java_junit5_esercizio.exception.FiguraException;

public class Quadrato extends Rettangolo {

	public Quadrato(double lato) {
		super(lato, lato);
	}

	public double getLato() {
		return getBase();
	}

	public void setLato(double lato) {
		if(lato > 0) {
			setBase(lato);
			setAltezza(lato);
		} else {
			throw new FiguraException("Il lato deve essere superiori a 0");
		}
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
