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
	
	

}
