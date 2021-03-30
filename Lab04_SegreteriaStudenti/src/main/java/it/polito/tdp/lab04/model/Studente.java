package it.polito.tdp.lab04.model;

public class Studente {
	
	private String Matricola;
	private String Nome;
	private String Cognome;
	private String CVS;
	
	public String getMatricola() {
		return Matricola;
	}
	public void setMatricola(String matricola) {
		Matricola = matricola;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getCVS() {
		return CVS;
	}
	public void setCVS(String cVS) {
		CVS = cVS;
	}
	
	public Studente(String matricola, String nome, String cognome, String cVS) {
		super();
		Matricola = matricola;
		Nome = nome;
		Cognome = cognome;
		CVS = cVS;
	}
	
	
	
	

}
