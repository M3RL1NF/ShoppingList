package shoppinglist.view;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Validator {
    
    private final JFrame frame;
    
    private String anzahl;
    private String name;
    private String preis;
    
    private boolean validated = false; 
    private String errorMessage = "";
    
    public Validator(JFrame frame) {
        this.frame = frame;
    }
    
    public boolean runValidation(JTextField anzahl, JTextField name, JTextField preis){
        this.anzahl = anzahl.getText();
        this.name = name.getText();
        this.preis = preis.getText();
        
        this.errorMessage();
        
        return validated;
    }
    
    public void errorMessage() {
        if (!this.validateAnzahl()){
            errorMessage = errorMessage + "Bitte geben Sie eine Ganzzahl an!" + "\n";
        }
        
        if (!this.validateName()){
            errorMessage = errorMessage + "Bitte geben Sie einen Artikel an!" + "\n";
        }
        
        if (!this.validatePreis()){
            errorMessage = errorMessage + "Bitte geben Sie einen Geldwert mit maximal zwei Nachkommastellen an und nutzen sie einen Punkt!" + "\n";
        }
        
        if (!errorMessage.isEmpty()){
            JOptionPane.showMessageDialog(frame, errorMessage);
        }
        else {
            validated = true;
        }
    }
    
    public boolean validateAnzahl() {
        return anzahl.matches("^[0-9]+$");
    }
    
    public boolean validateName() {
        return !name.isEmpty();
    }
    
    public boolean validatePreis() {
        return preis.matches("^\\d+(\\.\\d{0,2})?$");
    }
}