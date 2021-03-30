package it.polito.tdp.lab04;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> dropCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnVerde;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private Button btnCorsiStudente;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TableView<Studente> tblStampa;

    @FXML
    private TableColumn<Studente, String> colT1;

    @FXML
    private TableColumn<Studente, String> colT2;

    @FXML
    private TableColumn<Studente, String> colT3;

    @FXML
    private TableColumn<Studente, String> colT4;

    @FXML
    private Button btnReset;
    
    //trasforma una lista di corsi in una di studenti ---> serve per stampare comodamente
    private List<Studente> ConvertiLista(List<Corso> listC) {
    	
    	List <Studente> L = new LinkedList<Studente>();
    	
    	for (int i=0; i<listC.size(); i++) {
    		
    		String PerDid = "";
    		
    		if (listC.get(i).getPD()==1) {
    			PerDid  = "Primo Semestre";
    		} else if (listC.get(i).getPD()==2){
    			PerDid  = "Secondo Semestre";
    		}
    		
    		Studente S = new Studente(
    								listC.get(i).getCodice(),
    								Integer.toString(listC.get(i).getCrediti()),
    								listC.get(i).getNome(),
    								PerDid);
    		
    		L.add(S);
    		
    	}
		
		return L;
	}
    
    //funzione di stampa, prende una lista di studenti e la stampa sulla tabella
    private void Stampante(List<Studente> list, boolean b) {
    	
    	for ( int i = 0; i<tblStampa.getItems().size(); i++) {
    	    tblStampa.getItems().clear();
    	}
    	
    	if (b) {
    		
    		colT1.setText("Matricola");
    		colT2.setText("Nome Studente");
    		colT3.setText("Cognome Studente");
    		colT4.setText("CDS");
    		
    		
    	} else {
    		
    		colT1.setText("Codice Corso");
    		colT2.setText("Crediti");
    		colT3.setText("Nome Corso");
    		colT4.setText("PD");
    		
    	}
    	
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getCDS().equals(null)) {
				list.get(i).setCDS("");
			}
		}
    	
    	colT1.setCellValueFactory(new PropertyValueFactory("Matricola"));
    	colT2.setCellValueFactory(new PropertyValueFactory("Nome"));
    	colT3.setCellValueFactory(new PropertyValueFactory("Cognome"));
    	colT4.setCellValueFactory(new PropertyValueFactory("CDS"));
    	
    	for (int i=0; i<list.size(); i++) {
        	tblStampa.getItems().add(list.get(i));
        }
    	
    	
		
	}

    //mostra tutti gli iscritti al corso selezionato tramite drop
    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	
    	List<Studente> ListStu = new LinkedList<Studente>();
    	
    	if (dropCorso.getValue()==null) {
    		return;
    	}
    	
    	ListStu = model.CercaIscrittiCorso(dropCorso.getValue());
    	this.Stampante(ListStu, true);
    	
    }

    //mostra tutti i corsi a cui uno studente è iscritto
	@FXML
    void doCorsiStudente(ActionEvent event) {
		
		if (txtMatricola.getText().equals("")) {
			return;
		}
		
		List<Corso> ListC = model.CercaCorsiStudente(txtMatricola.getText());
		
		if (!(ListC==null)) {
			this.Stampante(this.ConvertiLista(ListC), false);
		}

    }

	//iscrive uno studente (matricola necessaria) al corso scelto tramite drop
	@FXML
    void doIscrivi(ActionEvent event) {
    	
    	String M = txtMatricola.getText();
    	String N = txtNome.getText();
    	String C = txtCognome.getText();
    	String Cor = dropCorso.getValue();
    	
    	if (M.equals("") || N.equals("") || C.equals("") || Cor.equals("") || Cor==null) {
    		return;
    	}
    	
    	if (this.model.IscriviStudente(M,N,C,Cor)) {
    	
    		this.Stampante(this.model.TuttiStudenti(), true);
    		
    	}

    }

	//pulisce l'interfaccia grafica
    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    	for ( int i = 0; i<tblStampa.getItems().size(); i++) {
    	    tblStampa.getItems().clear();
    	}
    }

    //esegue autocompletamento: data la matricola trovo nome e cognome
    @FXML
    void doVerde(ActionEvent event) {
    	
    	String M = txtMatricola.getText();
    	
    	if (M.equals("")) {
    		return;
    	}
    	
    	Studente S = this.model.verde(M);
    	
    	if (!(S==null)) {
    		
    		txtNome.setText(S.getNome());
        	txtCognome.setText(S.getCognome());
    		
    	}
    	

    }

    //inizializzo interfaccia grafica
    @FXML
    void initialize() {
        assert dropCorso != null : "fx:id=\"dropCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnVerde != null : "fx:id=\"btnVerde\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiStudente != null : "fx:id=\"btnCorsiStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblStampa != null : "fx:id=\"tblStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colT1 != null : "fx:id=\"colT1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colT2 != null : "fx:id=\"colT2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colT3 != null : "fx:id=\"colT3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colT4 != null : "fx:id=\"colT4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    //setto il model e la drop: devo farlo qua perchè prima il model non esiste
    public void setModel (Model m) {
    	this.model=m;
    	
    	List <Corso> C = this.model.TuttiCorsi();
        for (int i=0; i<C.size(); i++) {
        	dropCorso.getItems().add(C.get(i).getNome());
        }
        
        dropCorso.setValue(C.get(0).getNome());
    }
    
}
