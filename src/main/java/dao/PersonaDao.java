package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Persona;

public class PersonaDao {
	private DataSource dataSource = new DataSource();
	
	/* Restiruisce tutte le persone */

/*	public List<Persona> findAll() {

		List<Persona> utenti = new ArrayList<Persona>();

		Connection connection = this.dataSource.getConnection();
		Persona persona;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.persona";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				persona = new Persona();
				persona.setEmail(result.getString("email"));
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
				persona.setDataNascita(result.getDate("data_nascita"));
				

				utenti.add(persona);
			}

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

		return utenti;
	}*/

	/* Restiruisce tutte le persone che hanno quel dato id (LOGIN) */

	public List<Persona> findById(String id) {

		List<Persona> utenti = new ArrayList<Persona>();

		Connection connection = this.dataSource.getConnection();
		Persona persona;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.persona  WHERE persona.email = '" + id + "'";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				persona = new Persona();
				persona.setEmail(result.getString("email"));
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
				persona.setPassword(result.getString("password"));

				utenti.add(persona);
			}

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

		return utenti;
	}

	/* Inserisco nuovo utente se non e' presente (Provata Funzionante)*/

	public boolean inseriscoNuonoUtente(Persona p) {
		
		if(findById(p.getEmail()).size() == 0)
		{
		
		Connection connection = this.dataSource.getConnection();
			try {
//				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				PreparedStatement statment;
//				String query = "INSERT INTO public.persona (\r\n" + 
//						"email, nome, cognome, data_nascita, password) VALUES (\r\n" + 
//						"'" + p.getEmail() + "'::character varying(20), '"+ p.getNome() +"'::character varying(20), "
//						+ "'"+ p.getCognome() +"'::character varying(20), '"+ formatter.format(p.getDataNascita())+"'::date, '"+p.getPassword()+"'::character varying(20))\r\n" + 
//						" returning email;";
				
				
				String query = "INSERT INTO public.persona (\r\n" + 
						"email, nome, cognome, password) VALUES (\r\n" + 
						"'"+p.getEmail()+"'::character varying(20), '"+p.getNome()+"'::character varying(20), '"+p.getCognome()+"'::character varying(20), '"+ p.getPassword()+"'::character varying(20))\r\n" + 
						" returning email;"; 
				statment = connection.prepareStatement(query);
				ResultSet result = statment.executeQuery();

			} catch (SQLException e) {
				System.out.println("Problemi di connessione");
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					System.out.println("problemi di ciusura connessione");
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
				}
			}
			return true;
		}
		else
			return false;
		
	}
}
