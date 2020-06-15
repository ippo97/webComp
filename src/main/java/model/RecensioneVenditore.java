package model;

import java.util.Date;

public class RecensioneVenditore {
	int idRecensitore;
	int stelle;
	String emailVenditore;
	String emailRecensitore;
	String testo;
	String nomeRevensitore;
	Date data;
	
	public int getIdRecensitore() {
		return idRecensitore;
	}

	public void setIdRecensitore(int idRecensitore) {
 		this.idRecensitore = idRecensitore;
	}

	public int getStelle() {
		return stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

	public String getEmailVenditore() {
		return emailVenditore;
	}

	public void setEmailVenditore(String emailVenditore) {
		this.emailVenditore = emailVenditore;
	}

	public String getEmailRecensitore() {
		return emailRecensitore;
	}

	public void setEmailRecensitore(String emailRecensitore) {
		this.emailRecensitore = emailRecensitore;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getNomeRevensitore() {
		return nomeRevensitore;
	}

	public void setNomeRevensitore(String nomeRevensitore) {
		this.nomeRevensitore = nomeRevensitore;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RecensioneVenditore [idRecensitore=" + idRecensitore + ", stelle=" + stelle + ", emailVenditore="
				+ emailVenditore + ", emailRecensitore=" + emailRecensitore + ", testo=" + testo + ", nomeRevensitore="
				+ nomeRevensitore + ", data=" + data + "]";
	}

	
	

	
}
