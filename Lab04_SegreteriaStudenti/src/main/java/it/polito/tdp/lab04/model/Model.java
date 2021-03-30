package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private List<Corso> ListaCorsi = new LinkedList<Corso>();
	private List<Studente> ListaStudenti = new LinkedList<Studente>();
	
	CorsoDAO DAOC = new CorsoDAO();
	StudenteDAO DAOS = new StudenteDAO();
	
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
		
		String codice_trovato = "";
		
		this.ListaCorsi=DAOC.getTuttiICorsi();
		
		for (Corso C : ListaCorsi) {
			if (value.equals(C.getNome())){
				codice_trovato=C.getCodice();
				break;
			}
		}
		
		return DAOS.InterrogaIscrittiCorso(codice_trovato);

	}
	
	public List<Corso> CercaCorsiStudente(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean IscriviStudente(String m, String n, String c, String cor) {
		
		Studente STU = new Studente(m,n,c,"");
		Corso COR = new Corso();
		
		this.ListaCorsi=DAOC.getTuttiICorsi();
		
		for (Corso C : ListaCorsi) {
			if (C.getNome().equals(cor)){
				COR = C;
				break;
			}
		}
		
		
		if (DAOC.iscriviStudenteACorso(STU, COR)) {
			return true;
		}
		
		return false;
		
	}
	
	public List<Studente> TuttiStudenti() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Studente verde(String m) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Corso> TuttiCorsi() {
		
		List<Corso> C = DAOC.getTuttiICorsi();
		
		return C;
	}
	
	
	
	

}
