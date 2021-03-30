package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

//classe puramente dedicata ad inizializzare la connesione con il database
//verrà richiamata nelle parti DAO
public class ConnectDB {
	
	// check user e password
	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root";

	public static Connection getConnection() {

		try {
				//Connection connection = DriverManager.getConnection(jdbcUrl);
			
				@SuppressWarnings("resource")
				HikariDataSource connection = new HikariDataSource();
				connection.setJdbcUrl("jdbc:mysql://localhost:3306/iscritticorsi");
				connection.setUsername("root");
				connection.setPassword("root");
				return connection.getConnection();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
