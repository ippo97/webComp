package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Marca;

public class MarcaDao {

	private DataSource dataSource = new DataSource() ;

	public List<Marca> findAll() {

		List<Marca> marche = new ArrayList<Marca>();

		Connection connection = this.dataSource.getConnection();
		Marca marca;

		try {
			PreparedStatement statment;
			String query = "SELECT id_marca FROM public.marca";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				marca = new Marca();
				marca.setIdMarca(result.getString("id_marca"));
				marche.add(marca);
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

		return marche;
	}

	public Marca findByPrimaryKeyJoin(String id) {
		Connection connection = this.dataSource.getConnection();
		Marca marca = null;

		try {
			PreparedStatement statement;
			String query = "SELECT id_marca FROM public.marca where id_marca = '" + id + "' ";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					marca = new Marca();
					marca.setIdMarca(result.getString("id_marca"));
				}
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

		return marca;
	}
	
	public Marca trovaMarca(String id) {
		Connection connection = this.dataSource.getConnection();
		Marca marca = null;

		try {
			PreparedStatement statement;
			String query = "SELECT * FROM public.modello WHERE id_modello ='" + id +"'";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					marca = new Marca();
					marca.setIdMarca(result.getString("id_marca"));
				}
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

		return marca;
	}
}
