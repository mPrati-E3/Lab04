package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> InterrogaIscrittiCorso(String cod) {

		final String sql = "SELECT studente.matricola AS matricola, nome, cognome, cds\r\n"
				+ "	FROM studente\r\n"
				+ "	INNER JOIN iscrizione\r\n"
				+ "	ON studente.matricola=iscrizione.matricola\r\n"
				+ "	WHERE iscrizione.codins=?";

		List<Studente> Stu = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, cod);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String m = rs.getString("matricola");
				String n = rs.getString("nome");
				String c = rs.getString("cognome");
				String cds = rs.getString("cds");
				
				Studente S = new Studente(m,n,c,cds);
				
				Stu.add(S);
			}

			conn.close();
			
			return Stu;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
