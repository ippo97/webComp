package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Veicolo;

public class VeicoloDao {

	private DataSource dataSource = new DataSource();
	
	public List<Veicolo> findById(int id) {
		List<Veicolo> veicoli = new ArrayList<Veicolo>();
		Connection connection = this.dataSource.getConnection();
		Veicolo veicolo;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.veicolo WHERE id_veicolo = " + id;
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				veicolo = new Veicolo();
				veicolo.setIdVeicolo(result.getInt("id_veicolo"));
				veicolo.setKm(result.getInt("km"));
				veicolo.setAnnoImmatricolazione(result.getInt("anno_immatricolazione"));
				veicolo.setDataInserimentoAnnuncio(result.getDate("data_inserimento_ann"));
				veicolo.setDescrizione(result.getString("descrizione"));
				veicolo.setEmail(result.getString("email"));
				veicolo.setIdModello(result.getString("id_modello"));
				veicolo.setPrezzo(result.getInt("prezzo"));
				veicolo.setLinkUno(result.getString("linkUno"));
				veicolo.setLinkDue(result.getString("linkDue"));
				veicolo.setLinkTre(result.getString("linkTre"));
				veicolo.setAsta(result.getBoolean("is_asta"));
				
				veicoli.add(veicolo);
			}
		} catch (Exception e) {
			System.out.println("Problemi query in veicoloDao!");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return veicoli;
	}

	
	public List<Veicolo> crecaByModelloMarcaPrezzo (String modello, int prezzo) {
		List<Veicolo> veicoli = new ArrayList<Veicolo>();
		Connection connection = this.dataSource.getConnection();
		Veicolo veicolo;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.veicolo WHERE veicolo.id_modello = '" + modello + "' AND veicolo.prezzo <= " + prezzo;
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				veicolo = new Veicolo();
				veicolo.setIdVeicolo(result.getInt("id_veicolo"));
				veicolo.setKm(result.getInt("km"));
				veicolo.setAnnoImmatricolazione(result.getInt("anno_immatricolazione"));
				veicolo.setDataInserimentoAnnuncio(result.getDate("data_inserimento_ann"));
				veicolo.setDescrizione(result.getString("descrizione"));
				veicolo.setEmail(result.getString("email"));
				veicolo.setIdModello(result.getString("id_modello"));
				veicolo.setPrezzo(result.getInt("prezzo"));
				veicolo.setLinkUno(result.getString("linkUno"));
				veicolo.setLinkDue(result.getString("linkDue"));
				veicolo.setLinkTre(result.getString("linkTre"));
				veicolo.setAsta(result.getBoolean("is_asta"));
				
				veicoli.add(veicolo);
			}
		} catch (Exception e) {
			System.out.println("Problemi query in veicoloDao prezzo!");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return veicoli;
	}
	public int inserisciVeicolo(Veicolo v) {
		
		int id = -1;
		
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "INSERT INTO public.veicolo (\r\n" + 
					"id_veicolo, km, anno_immatricolazione, data_inserimento_ann, descrizione, email, id_modello, prezzo, \"linkUno\", \"linkDue\", \"linkTre\", is_asta) VALUES (\r\n" + 
					"nextval('veicolo_sequence') ::integer, '"+v.getKm()+"'::integer, '"+ v.getAnnoImmatricolazione()+"'::integer, '"+v.getDataInserimentoAnnuncio()+"'::date, '"+v.getDescrizione()+"'::character varying(100), '"+v.getEmail()+"'::character varying(20), '"+v.getIdModello()+"'::character varying(20), '"+v.getPrezzo()+"'::integer, '"+v.getLinkUno()+"'::character varying(50), '"+v.getLinkDue()+"'::character varying(50), '"+v.getLinkTre()+"'::character varying(50), "+ v.isAsta() +" ::boolean)\r\n" + 
					" returning id_veicolo;";
			PreparedStatement statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();
			
			while (result.next()) {
				id = result.getInt(1);
			}
			
			
		} catch (Exception eq) {
			return -1;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return id;
	}
	
	public boolean rimuoviVeicolo(int idVeicolo) {
		
		if(findById(idVeicolo).size() == 1) {
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "DELETE FROM public.veicolo\r\n" + 
					"    WHERE id_veicolo IN\r\n" + 
					"        (" + idVeicolo + ");";
			PreparedStatement statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

		} catch (SQLException ee) {
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return true;
	}else 
		return false;
	}
	

	public static void main(String[] args) {
		VeicoloDao vDao = new VeicoloDao();
		Veicolo veicolo = new Veicolo();
		
		veicolo.setKm(200);
		veicolo.setAnnoImmatricolazione(2020);
		veicolo.setDataInserimentoAnnuncio(new Date());
		veicolo.setDescrizione("descrizione");
		veicolo.setEmail("i");
		veicolo.setIdModello("500");
		veicolo.setPrezzo(2000);
		veicolo.setLinkUno("link.car");
		veicolo.setAsta(true);
		
		System.out.println(vDao.inserisciVeicolo(veicolo));

	}
}
