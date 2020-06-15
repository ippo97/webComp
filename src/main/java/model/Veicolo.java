package model;

import java.util.Date;

public class Veicolo {

	int idVeicolo;
	int km;
	int annoImmatricolazione;
	Date dataInserimentoAnnuncio;
	String descrizione;
	String email;
	String idModello;
	int prezzo;
	String linkUno;
	String linkDue;
	String linkTre;
	boolean isAsta;
	
	public int getIdVeicolo() {
		return idVeicolo;
	}
	public void setIdVeicolo(int idVeicolo) {
		this.idVeicolo = idVeicolo;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public Date getDataInserimentoAnnuncio() {
		return dataInserimentoAnnuncio;
	}
	public void setDataInserimentoAnnuncio(Date dataInserimentoAnnuncio) {
		this.dataInserimentoAnnuncio = dataInserimentoAnnuncio;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdModello() {
		return idModello;
	}
	public void setIdModello(String idModello) {
		this.idModello = idModello;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public String getLinkUno() {
		return linkUno;
	}
	public void setLinkUno(String linkUno) {
		this.linkUno = linkUno;
	}
	public String getLinkDue() {
		return linkDue;
	}
	public void setLinkDue(String linkDue) {
		this.linkDue = linkDue;
	}
	public String getLinkTre() {
		return linkTre;
	}
	public void setLinkTre(String linkTre) {
		this.linkTre = linkTre;
	}
	public boolean isAsta() {
		return isAsta;
	}
	public void setAsta(boolean isAsta) {
		this.isAsta = isAsta;
	}
	@Override
	public String toString() {
		return "Veicolo [idVeicolo=" + idVeicolo + ", km=" + km + ", annoImmatricolazione=" + annoImmatricolazione
				+ ", dataInserimentoAnnuncio=" + dataInserimentoAnnuncio + ", descrizione=" + descrizione + ", email="
				+ email + ", idModello=" + idModello + ", prezzo=" + prezzo + ", linkUno=" + linkUno + ", linkDue="
				+ linkDue + ", linkTre=" + linkTre + ", isAsta=" + isAsta + "]";
	}
	
	

	
}
