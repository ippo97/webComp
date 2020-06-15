package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecensioneVenditore;


public class RecensioneVenditoreDao {
	private DataSource dataSource = new DataSource();
	

	public boolean inseriscoRecensione(RecensioneVenditore rv) {

		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statment;
			//System.out.println(rv.toString());
			String query = "INSERT INTO public.rec_venditore (\r\n" + 
					"id_recensione, stelle, email_venditore, email_recensitore, testo, nome_recensirote, data) VALUES (\r\n" + 
					"nextval('recVenditore_sequence')::integer, '"+rv.getStelle()+"'::integer, '"+ rv.getEmailVenditore()+"'::character varying(20), '"+rv.getEmailRecensitore()+"'::character varying(20), '"+rv.getTesto()+"'::character varying(200), '"+rv.getNomeRevensitore()+"'::character varying(20), '"+rv.getData()+"'::date)\r\n" + 
					" returning id_recensione;";
			 statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

		} catch (SQLException e) {
			System.out.println("problemi di inserimento recensione!");
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return true;

	}
	
	public List<RecensioneVenditore> dammiRecensioneVenditore (String venditore) {
		List<RecensioneVenditore> recensioni = new ArrayList<RecensioneVenditore>();
		Connection connection = this.dataSource.getConnection();
		RecensioneVenditore rec;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.rec_venditore WHERE email_venditore = '" + venditore + "' ORDER by data DESC";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				rec = new RecensioneVenditore();
				
				rec.setIdRecensitore(result.getInt("id_recensione"));
				rec.setStelle(result.getInt("stelle"));
				rec.setEmailRecensitore(result.getString("email_recensitore"));
				rec.setEmailVenditore(result.getString("email_venditore"));
				rec.setNomeRevensitore(result.getString("nome_recensirote"));
				rec.setTesto(result.getString("testo"));
				rec.setData(result.getDate("data"));

				recensioni.add(rec);
			}
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return recensioni;
	}
	
	public static void main(String[] args) {
		RecensioneVenditoreDao d = new RecensioneVenditoreDao();
		RecensioneVenditore r = new RecensioneVenditore();
		r.setEmailVenditore("i");
		r.setStelle(3);
		r.setData(new Date(2010, 03, 12));
		r.setNomeRevensitore("Aldo");
		r.setEmailRecensitore("antostico");
		d.inseriscoRecensione(r);
		System.out.println(d.inseriscoRecensione(r)); 
	}
}

