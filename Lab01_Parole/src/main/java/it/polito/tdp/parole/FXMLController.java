package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Parole elenco ;
	private List<String> elP = new ArrayList<>();
	private String parola ="";
	private String parolaX ="";
	private long startTime=0;
	private long estimatedTime=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    
    
    
    
    @FXML
    void doInsert(ActionEvent event) {
    	this.startTime=System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	estimatedTime = System.nanoTime() - startTime;
    	this.txtParola.clear();
    	elP =elenco.getElenco();
    	for(String i: elP) {
    		this.parola = parola +i+"\n";
    	}
    	this.txtResult.setText(parola);
    	parola="";
    	this.txtTempo.setText("Tempo operazione in nanosecondi: "+this.estimatedTime+" ns");
    }

    
    
    
    @FXML
    void doReset(ActionEvent event) {
    	this.startTime=System.nanoTime();
    	this.elenco.reset();
    	estimatedTime = System.nanoTime() - startTime;
    	this.txtResult.clear();
    	this.txtTempo.setText("Tempo operazione in nanosecondi: "+this.estimatedTime+" ns");
    }
    
    
    
    @FXML
    void doCancella(ActionEvent event) {
    	this.startTime=System.nanoTime();
    	this.elP=elenco.eliminaParola(this.txtResult.getSelectedText());
    	estimatedTime = System.nanoTime() - startTime;
    	for(String i: elP) {
    		this.parolaX = parolaX +i+"\n";
    	}
    	this.txtResult.setText(parolaX);
    	parolaX="";
    	this.txtTempo.setText("Tempo operazione in nanosecondi: "+this.estimatedTime+" ns");

    }
    
    
    

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
