package dao;

import java.sql.*;

class DataSource {
	final private String dbURI ; 	//= "jdbc:postgresql://localhost:5432/vendo_auto";// = "jdbc:postgresql://localhost/test";
	final private String userName ;	//= "postgres";// = "postgres";
	final private String password; 	//= "admin";// = "postgres";
	
	

	public DataSource () {
		// Per connettermi dv mettere questo oppure non va
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		this.dbURI = "jdbc:postgresql://lallah.db.elephantsql.com:5432/qrztixdn";
		this.userName = "qrztixdn";
		this.password = "6Ky8hqiEymprEFgV3v0vzcHQW3Qf0_Pn";
		//this.dbURI = "jdbc:postgresql://localhost:5432/progetto_siv";//"jdbc:postgresql://localhost:5432/vendo_auto";
		//this.userName = "postgres";
		//this.password = "admin";
	}
	


	public Connection getConnection()  {
		Connection connection = null;
		try {
		    connection = DriverManager.getConnection(dbURI,userName, password);
			//connection = DriverManager.getConnection("jdbc:postgresql://dumbo.db.elephantsql.com:5432/pomdxlpa", "pomdxlpa", "CT9m2BEOOTt2prmx3AVWLQh-vrqVr1ba");
			//System.out.println("Connessione stabilit con successo " + userName);
		
		} catch(SQLException e) {
			e.printStackTrace();
			//System.out.println("Impossibile connettere l'utente " + userName);
		}
		return connection;
	}
}
