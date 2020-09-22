package model;

import java.util.Date;

public class Puntata {
	int idPuntata;
	int idAsta;
	String idPersona;
	double puntata;
	private java.util.Date oraPuntata;
	
	public int getIdPuntata() {
		return idPuntata;
	}
	public void setIdPuntata(int idPuntata) {
		this.idPuntata = idPuntata;
	}
	public int getIdAsta() {
		return idAsta;
	}
	public void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public double getPuntata() {
		return puntata;
	}
	public void setPuntata(double puntata) {
		this.puntata = puntata;
	}
	
	public java.util.Date getOraPuntata() {
		return oraPuntata;
	}
	public void setOraPuntata(java.util.Date oraPuntata) {
		this.oraPuntata = oraPuntata;
	}
	@Override
	public String toString() {
		return "Puntata [idPuntata=" + idPuntata + ", idAsta=" + idAsta + ", idPersona=" + idPersona + ", puntata="
				+ puntata + ", oraPuntata=" + oraPuntata + "]";
	}
	

}
