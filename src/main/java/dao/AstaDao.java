package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import model.Asta;

public class AstaDao {
	private DataSource dataSource = new DataSource();
	
	public boolean inseriscoAsta(Asta asta) {

		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statment;
			String query = "INSERT INTO public.asta (\r\n" + 
					"id_asta, id_veicolo_fk, fine_asta, base_asta, id_venditore) VALUES (\r\n" + 
					"nextval('asta_sequence')::integer, '"+ asta.getId_veicolo() +"'::integer, '"+asta.getDataFineAsta()+"'::timestamp with time zone, '"+asta.getBaseAsta()+"'::integer, '"+asta.getId_venditore() +"'::character varying(20))\r\n" + 
					" returning id_asta;";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

		} catch (SQLException e) {
			System.out.println("Problemi di inserimento Asta!" + e);
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
	
	
	
	public ArrayList<Asta> dammiAste() {
		ArrayList<Asta> aste = new ArrayList<Asta>();
		Connection connection = this.dataSource.getConnection();
		Asta a;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.asta\r\n";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				a = new Asta();
				
				a.setId_asta(result.getInt("id_asta"));
				a.setBaseAsta(result.getInt("base_asta"));
				a.setDataFineAsta(new SimpleDateFormat("yyyy-mm-dd").parse(result.getString("fine_asta")));
				a.setId_veicolo(result.getInt("id_veicolo_fk"));
				a.setPrezzoFinale(result.getInt("prezzo_finale"));
				a.setUtenteVincitore(result.getString("vincitore_asta"));
				a.setId_venditore(result.getString("id_venditore"));
				aste.add(a);
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
		return aste;
	}
	
	public ArrayList<Asta> cercaAstaById(int id) {
		ArrayList<Asta> aste = new ArrayList<Asta>();
		Connection connection = this.dataSource.getConnection();
		Asta a;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.asta WHERE id_asta = " + id +"\r\n";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				a = new Asta();
				
				a.setId_asta(result.getInt("id_asta"));
				a.setBaseAsta(result.getInt("base_asta"));
				a.setDataFineAsta(new SimpleDateFormat("yyyy-mm-dd").parse(result.getString("fine_asta")));
				a.setId_veicolo(result.getInt("id_veicolo_fk"));
				a.setPrezzoFinale(result.getInt("prezzo_finale"));
				a.setUtenteVincitore(result.getString("vincitore_asta"));
				a.setId_venditore(result.getString("id_venditore"));
				aste.add(a);
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
		return aste;
	}
	
	public ArrayList<Asta> dammiAstePerVisualizzare() {
		ArrayList<Asta> aste = new ArrayList<Asta>();
		Connection connection = this.dataSource.getConnection();
		Asta a;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.asta";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();
			int index = 0;
			while (result.next() &&  index<8) {
				a = new Asta();
				
				a.setId_asta(result.getInt("id_asta"));
				a.setBaseAsta(result.getInt("base_asta"));
				a.setDataFineAsta(new SimpleDateFormat("yyyy-mm-dd").parse(result.getString("fine_asta")));
				a.setId_veicolo(result.getInt("id_veicolo_fk"));
				a.setPrezzoFinale(result.getInt("prezzo_finale"));
				a.setUtenteVincitore(result.getString("vincitore_asta"));
				a.setId_venditore(result.getString("id_venditore"));
				aste.add(a);
				index++;
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
		return aste;
	}
	
	
	
	
	
	public static void main(String[] args) throws ParseException {
		
//		Asta sdf= new Asta();
//		sdf.setId_veicolo(75);
//		sdf.setBaseAsta(5000);
//		Date data = new Date();
//		sdf.setDataFineAsta(data);
//		AstaDao asd =new AstaDao();
//		
//		for(Asta a : asd.dammiAste())
		AstaDao ad = new AstaDao();
		System.out.println(ad.cercaAstaById(12));
		
		
	}
}
