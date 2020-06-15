package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Puntata;

public class PuntataDao {
	private DataSource dataSource = new DataSource();
	
	public boolean inseriscoPuntata(Puntata puntata) {

		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statment;
			String query = "INSERT INTO public.puntata ("
						+ "id_puntata, id_persona, id_asta, puntata, ora_puntata) VALUES "
						+ "(nextval('puntata_sequence')::integer, '"+puntata.getIdPersona()+"'::character varying(20), '"+puntata.getIdAsta()+"'::integer, '"+puntata.getPuntata()+"'::double precision, '"+puntata.getOraPuntata()+"'::timestamp with time zone) returning id_puntata;";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

		} catch (SQLException e) {
			System.out.println("Problemi di inserimento Puntata!" + e);
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
	
	public ArrayList<Puntata> dammiPuntateById(int idAsta) {
		ArrayList<Puntata> punt = new ArrayList<Puntata>();
		Connection connection = this.dataSource.getConnection();
		Puntata p;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.puntata WHERE id_asta = "+ idAsta+" ORDER BY ora_puntata desc";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				p = new Puntata();
				
				p.setIdPuntata(result.getInt("id_puntata"));
				p.setIdPersona(result.getString("id_persona"));
				p.setIdAsta(result.getInt("id_asta"));
				p.setPuntata(result.getDouble("puntata"));
				p.setOraPuntata(new SimpleDateFormat("yyyy-mm-dd").parse(result.getString("ora_puntata")));
				
				System.out.println(result.getDouble("puntata"));
				
				punt.add(p);
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
		return punt;
	}
	
	public ArrayList<Puntata> dammiPuntataAttuale(int idAsta) {
		ArrayList<Puntata> punt = new ArrayList<Puntata>();
		Connection connection = this.dataSource.getConnection();
		Puntata p;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.puntata WHERE id_asta = "+ idAsta+" ORDER BY puntata desc";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				p = new Puntata();
				
				p.setIdPuntata(result.getInt("id_puntata"));
				p.setIdPersona(result.getString("id_persona"));
				p.setIdAsta(result.getInt("id_asta"));
				p.setPuntata(result.getDouble("puntata"));
				p.setOraPuntata(new SimpleDateFormat("yyyy-mm-dd").parse(result.getString("ora_puntata")));
				
				System.out.println(result.getDouble("puntata"));
				
				punt.add(p);
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
		return punt;
	}
	
	
	public static void main(String[] args) throws ParseException {
		Puntata p = new Puntata();
		
		p.setIdPuntata(12);
		p.setIdPersona("i");
		p.setIdAsta(1);
		p.setPuntata(125.56);
		p.setOraPuntata(new SimpleDateFormat("yyyy-mm-dd").parse("2200-02-12"));
		
		PuntataDao pDa = new PuntataDao();
		System.out.println(pDa.inseriscoPuntata(p));
	}
}
