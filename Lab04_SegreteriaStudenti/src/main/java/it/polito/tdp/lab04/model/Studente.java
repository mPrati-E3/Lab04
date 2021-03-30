package it.polito.tdp.lab04.model;

//javabean per definire uno studente
public class Studente {
	
	private int Matricola;
	private String Nome;
	private String Cognome;
	private String CDS;
	
	public int getMatricola() {
		return Matricola;
	}
	public void setMatricola(int matricola) {
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
	public String getCDS() {
		return CDS;
	}
	public void setCDS(String cdS) {
		CDS = cdS;
	}
	
	public Studente(int matricola, String nome, String cognome, String cdS) {
		super();
		Matricola = matricola;
		Nome = nome;
		Cognome = cognome;
		CDS = cdS;
	}
	
	@SuppressWarnings("null")
	public Studente() {
		super();
		Matricola = (Integer) null;
		Nome = "";
		Cognome = "";
		CDS = "";
	}
	
	
	
	

}
