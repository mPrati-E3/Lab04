package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	//Ottengo tutti i corsi salvati nel Db
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				Corso C = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				
				corsi.add(C);
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	//Dato un codice insegnamento, ottengo il corso
	public Corso getCorso(String cod) {
		
		final String sql = "SELECT * FROM corso WHERE codins=?";
		
		Corso C = new Corso();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, cod);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				C = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				
				conn.close();
				
				return C;
				
			}


		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		return C;
	}

	//Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	public boolean iscriviStudenteACorso(Studente studente, Corso corso) {
		
		final String sql1 = "INSERT INTO studente (matricola,nome,cognome,cds) VALUES (?, ?, ?, '')";
		final String sql2 = "INSERT INTO iscrizione (matricola,codins) VALUES (?, ?)";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st1 = conn.prepareStatement(sql1);
			PreparedStatement st2 = conn.prepareStatement(sql2);
			
			st1.setString(1, studente.getMatricola() );
			st1.setString(2, studente.getNome());
			st1.setString(3, studente.getCognome());
			
			st2.setString(1, studente.getMatricola());
			st2.setString(2, corso.getCodice());

			st1.executeUpdate();
			st2.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	//ritorna tutti i corsi a cui un determinato studente (matricola) è iscritto
	public List<Corso> RitornaCorsiStudente(String text) {
		
		final String sql = "SELECT corso.codins as cod,nome,crediti,pd \r\n"
				+ "FROM corso \r\n"
				+ "INNER JOIN iscrizione\r\n"
				+ "ON iscrizione.codins=corso.codins\r\n"
				+ "WHERE iscrizione.matricola=?";
		
		Corso C = new Corso();
		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, text);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("cod");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				C = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				
				corsi.add(C);
				
				conn.close();
				
				return corsi;
				
			}


		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		return corsi;
	}


}
