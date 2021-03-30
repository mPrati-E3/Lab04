package it.polito.tdp.lab04.model;

public class Corso {
	
	private String Codice;
	private int Crediti;
	private String Nome;
	private int PD;
	
	public String getCodice() {
		return Codice;
	}
	public void setCodice(String codice) {
		Codice = codice;
	}
	public int getCrediti() {
		return Crediti;
	}
	public void setCrediti(int crediti) {
		Crediti = crediti;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getPD() {
		return PD;
	}
	public void setPD(int pD) {
		PD = pD;
	}
	
	public Corso(String codice, int crediti, String nome, int pD) {
		super();
		Codice = codice;
		Crediti = crediti;
		Nome = nome;
		PD = pD;
	}
	
	

}
