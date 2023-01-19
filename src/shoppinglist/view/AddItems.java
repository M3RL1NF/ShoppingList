package shoppinglist.view;

import java.awt.Dimension;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import shoppinglist.controller.*;

public class AddItems implements ActionListener{
    
    public Controller controller;
    
    public AddItems(Controller controller){
        this.controller = controller;
    }
    
    private JFrame frame;
    private JPanel panel;
    private JTextField inputAnzahl;
    private JLabel labelAnzahl;
    private JTextField inputName;
    private JLabel labelName;
    private JTextField inputPreis;
    private JLabel labelPreis;
    private JButton confirmButton;
    private JButton cancelButton;
    
    public void GUI(){
        frame = new JFrame();
        panel = new JPanel();
        
        frame.setTitle("Fügen sie einen Artikel hinzu!");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(313, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        panel.setLayout(null);
        
        labelAnzahl = new JLabel("Anzahl: ");
        labelAnzahl.setBounds(50, 7, 70, 20);
        
        inputAnzahl = new JTextField();
        inputAnzahl.setBounds(50, 27, 193, 28);
        
        labelName = new JLabel("Artikel: ");
        labelName.setBounds(50, 55, 70, 20);
        
        inputName = new JTextField();
        inputName.setBounds(50, 75, 193, 28);
        
        labelPreis = new JLabel("Preis: ");
        labelPreis.setBounds(50, 103, 90, 20);
        
        inputPreis = new JTextField();
        inputPreis.setBounds(50, 123, 193, 28);
        
        confirmButton = new JButton("Hinzufügen");
        confirmButton.addActionListener(this);
        confirmButton.setBounds(50, 160, 193, 28);
        
        cancelButton = new JButton("Abbrechen");
        cancelButton.addActionListener(this);
        cancelButton.setBounds(50, 195, 193, 28);
        
        panel.add(labelAnzahl);
        panel.add(inputAnzahl);
        panel.add(labelName);
        panel.add(inputName);
        panel.add(labelPreis);
        panel.add(inputPreis);
        panel.add(confirmButton);
        panel.add(cancelButton);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object button = e.getSource();
    
        if(button == confirmButton){
            if (!inputAnzahl.getText().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(frame, "Bitte geben Sie nur eine Ganzzahl ein!");
            } else if (inputName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Bitte geben Sie einen Artikel an!");
            } else if (!inputPreis.getText().matches("^\\d+(\\.\\d{0,2})?$")) {
                JOptionPane.showMessageDialog(frame, "Bitte geben Sie eine Zahl mit maximal 2 Nachkommastellen an!");
            } else {
                int newAnzahl = Integer.parseInt(inputAnzahl.getText());
                String newName = inputName.getText();
                double newPreis = Double.parseDouble(inputPreis.getText());

                controller.addItem(newAnzahl, newName, newPreis, false);
                frame.dispose();
            }
        }
        
        if(button == cancelButton){
            frame.dispose();
        }
    }
}