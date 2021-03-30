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
	
	//cerca quali studenti sono iscritti ad un determinato corso (nome)
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
	
	//cerca tutti i corsi a cui uno studente è iscritto
	public List<Corso> CercaCorsiStudente(String text) {
		
		return DAOC.RitornaCorsiStudente(text);
		
	}
	
	//iscrive uno studente ad un corso 
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
	
	//restituisce tutti gli studenti del database
	public List<Studente> TuttiStudenti() {
		
		this.ListaStudenti=DAOS.getTuttiStudenti();
		
		return ListaStudenti;
	}
	
	//effettua autocompletamento partendo dalla matricola
	public Studente verde(String m) {
		
		this.ListaStudenti=DAOS.getTuttiStudenti();
		
		for(Studente S : ListaStudenti) {
			if (S.getMatricola().equals(m)) {
				return S;
			}
		}
			
		return null;
	}
	
	//restituisce tutti i corsi presenti nel database
	public List<Corso> TuttiCorsi() {
		
		List<Corso> C = DAOC.getTuttiICorsi();
		
		return C;
	}
	
	
	
	

}
