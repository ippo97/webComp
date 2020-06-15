package model;
import java.util.Date;
public class Asta {
	private int id_asta;
	private int id_veicolo;
	private Date dataFineAsta;
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
	public Date getDataFineAsta() {
		return dataFineAsta;
	}
	public void setDataFineAsta(Date dataFineAsta) {
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
	
	
}
