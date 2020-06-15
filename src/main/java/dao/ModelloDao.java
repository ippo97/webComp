package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Modello;

public class ModelloDao {

	private DataSource dataSource = new DataSource();

	public List<Modello> findbyKey(String idMarca) {
		List<Modello> modelli = new ArrayList<Modello>();

		Connection connection = this.dataSource.getConnection();
		Modello modello;

		try {
			PreparedStatement statment;
			String query = "SELECT * FROM public.modello WHERE id_marca = '" + idMarca + "'";
			statment = connection.prepareStatement(query);
			ResultSet result = statment.executeQuery();

			while (result.next()) {
				modello = new Modello();
				modello.setIdMarca(result.getString("id_marca"));
				modello.setIdModello(result.getString("id_modello"));
				modelli.add(modello);
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

		return modelli;
	}
}
