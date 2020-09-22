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
		System.out.println("AstaDao " + asta.getDataFineAsta());// sbagliato
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statment;
			String query = "INSERT INTO public.asta (\r\n"
					+ "id_asta, id_veicolo_fk, fine_asta, base_asta, id_venditore) VALUES (\r\n"
					+ "nextval('asta_sequence')::integer, '" + asta.getId_veicolo() + "'::integer, '"
					+ asta.getDataFineAsta() + "'::timestamp with time zone, '" + asta.getBaseAsta() + "'::integer, '"
					+ asta.getId_venditore() + "'::character varying(20))\r\n" + " returning id_asta;";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

		} catch (SQLException e) {
			// System.out.println("Problemi di inserimento Asta!" + e);
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

				/* Gestione della Data */
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date nuovaData = format.parse(result.getString("fine_asta"));
				a.setDataFineAsta(nuovaData);

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
			String query = "SELECT * FROM public.asta WHERE id_asta = " + id + "\r\n";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				a = new Asta();

				a.setId_asta(result.getInt("id_asta"));
				a.setBaseAsta(result.getInt("base_asta"));

				/* Gestione della Data */
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date nuovaData = format.parse(result.getString("fine_asta"));
				a.setDataFineAsta(nuovaData);

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
			while (result.next() && index < 8) {
				Date oggi = new Date();
				/* Gestione della Data */
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date nuovaData = format.parse(result.getString("fine_asta"));

				if (oggi.before(nuovaData)) {

					a = new Asta();

					a.setId_asta(result.getInt("id_asta"));
					a.setBaseAsta(result.getInt("base_asta"));

					/* Gestione della Data */
					// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// java.util.Date nuovaData = format.parse(result.getString("fine_asta"));
					a.setDataFineAsta(nuovaData);

					a.setId_veicolo(result.getInt("id_veicolo_fk"));
					a.setPrezzoFinale(result.getInt("prezzo_finale"));
					a.setUtenteVincitore(result.getString("vincitore_asta"));
					a.setId_venditore(result.getString("id_venditore"));
					aste.add(a);
					index++;
				}
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

	public ArrayList<Asta> dammiIdAstaPerVeicolo(int idVeicolo) {
		ArrayList<Asta> aste = new ArrayList<Asta>();
		Connection connection = this.dataSource.getConnection();
		Asta a;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.asta where id_veicolo_fk = '" + idVeicolo + "'";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();
			int index = 0;
			while (result.next() && index < 8) {
				a = new Asta();

				a.setId_asta(result.getInt("id_asta"));
				a.setBaseAsta(result.getInt("base_asta"));

				/* Gestione della Data */
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date nuovaData = format.parse(result.getString("fine_asta"));
				a.setDataFineAsta(nuovaData);

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

	public boolean inserisciVincitoreAsta(int idAsta, String idPersona, int prezzo) {
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statment;
			String query = "UPDATE public.asta SET\r\n" + "vincitore_asta = '" + idPersona
					+ "'::character varying(20), prezzo_finale = '" + prezzo + "'::integer WHERE\r\n" + "id_asta = "
					+ idAsta + ";";
			statment = connection.prepareStatement(query);
			statment.executeUpdate();

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

	public static void main(String[] args) throws ParseException {
		AstaDao aDao = new AstaDao();
		System.out.println(aDao.dammiIdAstaPerVeicolo(39).get(0).toString());
	}
}
