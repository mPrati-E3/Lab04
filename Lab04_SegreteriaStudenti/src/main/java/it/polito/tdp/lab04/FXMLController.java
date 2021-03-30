package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> dropCorso;

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
    private TableColumn<?, ?> colT1;

    @FXML
    private TableColumn<?, ?> colT2;

    @FXML
    private TableColumn<?, ?> colT3;

    @FXML
    private TableColumn<?, ?> colT4;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void doCorsiStudente(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doVerde(ActionEvent event) {

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
}
