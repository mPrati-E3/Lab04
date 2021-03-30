package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	//ritorna quali studenti sono iscritti ad un determinato corso
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

				int m = rs.getInt("matricola");
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
	
	//ritorna tutti gli studenti presenti nel database
	public List<Studente> getTuttiStudenti() {

		final String sql = "SELECT matricola,nome,cognome,cds FROM studente";

		List<Studente> stu = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int M = rs.getInt("matricola");
				String N = rs.getString("nome");
				String C = rs.getString("cognome");
				String CDS = rs.getString("cds");
				
				Studente S = new Studente(M,N,C,CDS);
				
				stu.add(S);
			}

			conn.close();
			
			return stu;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
