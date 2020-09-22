package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Asta {
	private int id_asta;
	private int id_veicolo;
	//private Date dataFineAsta;
	private java.util.Date dataFineAsta;///---------------fix date
	private int baseAsta;
	private int prezzoFinale;
	private String utenteVincitore;
	private String id_venditore;
	
	public int getId_asta() {
		return id_asta;
	}
	public void setId_asta(int id_asta) {
		this.id_asta = id_asta;
	}
	public int getId_veicolo() {
		return id_veicolo;
	}
	public void setId_veicolo(int id_veicolo) {
		this.id_veicolo = id_veicolo;
	}
	public java.util.Date getDataFineAsta() {
		return dataFineAsta;
	}
	public void setDataFineAsta(java.util.Date dataFineAsta) {
		this.dataFineAsta = dataFineAsta;
	}
	public int getBaseAsta() {
		return baseAsta;
	}
	public void setBaseAsta(int baseAsta) {
		this.baseAsta = baseAsta;
	}
	public int getPrezzoFinale() {
		return prezzoFinale;
	}
	public void setPrezzoFinale(int prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}
	public String getUtenteVincitore() {
		return utenteVincitore;
	}
	public void setUtenteVincitore(String utenteVincitore) {
		this.utenteVincitore = utenteVincitore;
	}
	public String getId_venditore() {
		return id_venditore;
	}
	public void setId_venditore(String id_venditore) {
		this.id_venditore = id_venditore;
	}
	
	@Override
	public String toString() {
		return "Asta [id_asta=" + id_asta + ", id_veicolo=" + id_veicolo + ", dataFineAsta=" + dataFineAsta
				+ ", baseAsta=" + baseAsta + ", prezzoFinale=" + prezzoFinale + ", utenteVincitore=" + utenteVincitore
				+ ", id_venditore=" + id_venditore + "]";
	}
	
	public static void main(String[] args) throws ParseException {		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strData = "2020-02-26 22:02:00+01";  
		java.util.Date nuovaData = format.parse(strData);
	
		Asta a = new Asta();
		a.setDataFineAsta(nuovaData);
		/*format.format(fechaNueva)*/
		System.out.println(a.getDataFineAsta()); // Prints 2013-10-10 10:49:29
	}
}
