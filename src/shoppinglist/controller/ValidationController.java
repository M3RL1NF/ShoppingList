package shoppinglist.controller;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

// validate inputs from view
public class ValidationController {
    
    private final JFrame frame;
    
    private String anzahl;
    private String name;
    private String preis;
    
    private boolean validated = false; 
    private String errorMessage = "";
    
    public ValidationController(JFrame frame) {
        this.frame = frame;
    }
    
    // validate textfield inputs
    public boolean runValidation(JTextField anzahl, JTextField name, JTextField preis){
        this.anzahl = anzahl.getText();
        this.name = name.getText();
        this.preis = preis.getText();
        
        this.errorMessage();
        
        return validated;
    }
    
    // build error message and open dialog
    public void errorMessage() {
        if (!this.validateAnzahl()){
            errorMessage = errorMessage + "Bitte geben Sie eine Anzahl an!" + "\n";
        }
        
        if (!this.validateName()){
            errorMessage = errorMessage + "Bitte geben Sie einen Artikel an!" + "\n";
        }
        
        if (!this.validatePreis()){
            errorMessage = errorMessage + "Bitte geben Sie einen Preis an!" + "\n";
        }
        
        if (!errorMessage.isEmpty()){
            JOptionPane.showMessageDialog(frame, errorMessage);
        }
        else {
            validated = true;
        }
    }
    
    // check regex match
    public boolean validateAnzahl() {
        return anzahl.matches("^[0-9]+$");
    }
    
    // check not empty
    public boolean validateName() {
        return !name.isEmpty();
    }
    
    // check regex match
    public boolean validatePreis() {
        return preis.matches("^(\\d+)([.,]\\d{1,2})?$");
    }
}