package it.polito.tdp.lab04;

import java.net.URL;
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
    private TableView<?> tblStampa;

    @FXML
    private TableColumn<?, String> colT1;

    @FXML
    private TableColumn<?, ?> colT2;

    @FXML
    private TableColumn<?, String> colT3;

    @FXML
    private TableColumn<?, ?> colT4;

    @FXML
    private Button btnReset;
    
    private void Stampante(List<?> list, boolean b) {
    	
    	for ( int i = 0; i<tblStampa.getItems().size(); i++) {
    	    tblStampa.getItems().clear();
    	}
    	
    	if (b) {
    		
    		colT1.setText("Matricola");
    		colT2.setText("Nome Studente");
    		colT3.setText("Cognome Studente");
    		colT4.setText("CDS");
    		
    		colT1.setCellValueFactory(new PropertyValueFactory("Matricola"));
        	colT2.setCellValueFactory(new PropertyValueFactory("Nome"));
        	colT3.setCellValueFactory(new PropertyValueFactory("Cognome"));
        	colT4.setCellValueFactory(new PropertyValueFactory("CDS"));

    		
    	} else {
    		
    		colT1.setText("Codice Corso");
    		colT2.setText("Crediti");
    		colT3.setText("Nome Corso");
    		colT4.setText("PD");
    		
    		colT1.setCellValueFactory(new PropertyValueFactory("Codice"));
        	colT2.setCellValueFactory(new PropertyValueFactory("Crediti"));
        	colT3.setCellValueFactory(new PropertyValueFactory("Nome"));
        	colT4.setCellValueFactory(new PropertyValueFactory("PD"));
    		
    	}
    	
    	for (int i=0; i<list.size(); i++) {
        	tblStampa.getItems().add(list.get(i));
        }
    	
    	
    	
		
	}

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	
    	if (dropCorso.getValue()==null) {
    		return;
    	}
    	
    	List<Studente> ListStu = model.CercaIscrittiCorso(dropCorso.getValue());
    	this.Stampante(ListStu, true);
    	
    }


	@FXML
    void doCorsiStudente(ActionEvent event) {
		
		if (txtMatricola.getText().equals("")) {
			return;
		}
		
		List<Corso> ListC = model.CercaCorsiStudente(txtMatricola.getText());
    	this.Stampante(ListC, false);

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	
    	String M = txtMatricola.getText();
    	String N = txtNome.getText();
    	String C = txtCognome.getText();
    	
    	if (M.equals("") || N.equals("") || C.equals("")) {
    		return;
    	}
    	
    	this.model.IscriviStudente(M,N,C);
    	
    	this.Stampante(this.model.TuttiStudenti(), true);

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    	for ( int i = 0; i<tblStampa.getItems().size(); i++) {
    	    tblStampa.getItems().clear();
    	}
    }

    @FXML
    void doVerde(ActionEvent event) {
    	
    	String M = txtMatricola.getText();
    	
    	if (M.equals("")) {
    		return;
    	}
    	
    	Studente S = this.model.verde(M);
    	
    	txtNome.setText(S.getNome());
    	txtCognome.setText(S.getCognome());

    }

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
    
    public void setModel (Model m) {
    	this.model=m;
    }
    
}
