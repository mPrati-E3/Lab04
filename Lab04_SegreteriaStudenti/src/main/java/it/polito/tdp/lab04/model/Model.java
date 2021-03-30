package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Corso> ListaCorsi = new LinkedList<Corso>();
	private List<Studente> ListaStudenti = new LinkedList<Studente>();
	
	public List<Corso> getListaCorsi() {
		return ListaCorsi;
	}
	public void setListaCorsi(List<Corso> listaCorsi) {
		ListaCorsi = listaCorsi;
	}
	public List<Studente> getListaStudenti() {
		return ListaStudenti;
	}
	public void setListaStudenti(List<Studente> listaStudenti) {
		ListaStudenti = listaStudenti;
	}
	
	
	public List<Studente> CercaIscrittiCorso(String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Corso> CercaCorsiStudente(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void IscriviStudente(String m, String n, String c) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Studente> TuttiStudenti() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Studente verde(String m) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
