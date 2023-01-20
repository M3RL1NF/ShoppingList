package shoppinglist.view;

import shoppinglist.controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// load add item view
public class AddItemView implements ActionListener {
    
    public MainController mainController;
    
    public AddItemView(MainController mainController) {
        this.mainController = mainController;
    }
    
    private JFrame     frame;
    private JPanel     panel;
    private JTextField inputAnzahl;
    private JLabel     labelAnzahl;
    private JTextField inputName;
    private JLabel     labelName;
    private JTextField inputPreis;
    private JLabel     labelPreis;
    private JButton    confirmButton;
    private JButton    cancelButton;
    
    public void GUI() {
        frame = new JFrame();
        panel = new JPanel();
        
        // create add item frame
        frame.setTitle("Artikel hinzufügen!");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(313, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        panel.setLayout(null);
        
        // view properties set for default window size 1080p
        labelAnzahl   = new JLabel("Anzahl: ");
        labelAnzahl.setBounds(50, 7, 70, 20);
        
        inputAnzahl   = new JTextField();
        inputAnzahl.setBounds(50, 27, 193, 28);
        
        labelName     = new JLabel("Artikel: ");
        labelName.setBounds(50, 55, 70, 20);
        
        inputName     = new JTextField();
        inputName.setBounds(50, 75, 193, 28);
        
        labelPreis    = new JLabel("Preis: ");
        labelPreis.setBounds(50, 103, 90, 20);
        
        inputPreis    = new JTextField();
        inputPreis.setBounds(50, 123, 193, 28);
        
        confirmButton = new JButton("Hinzufügen");
        confirmButton.addActionListener(this);
        confirmButton.setBounds(50, 160, 193, 28);
        
        cancelButton  = new JButton("Abbrechen");
        cancelButton.addActionListener(this);
        cancelButton.setBounds(50, 195, 193, 28);
        
        // add labels and text fields to panel
        panel.add(labelAnzahl);
        panel.add(inputAnzahl);
        panel.add(labelName);
        panel.add(inputName);
        panel.add(labelPreis);
        panel.add(inputPreis);
        panel.add(confirmButton);
        panel.add(cancelButton);
        
        // show frame
        frame.setVisible(true);
    }
    
    // button function
    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        
        // call add item function
        if (button == confirmButton) {
            ValidationController validationController = new ValidationController(frame);
            if (validationController.runValidation(inputAnzahl, inputName, inputPreis)) {
                int newAnzahl   = Integer.parseInt(inputAnzahl.getText());
                String newName  = inputName.getText();
                double newPreis = Double.parseDouble(inputPreis.getText().replaceAll(",", "."));

                mainController.addItem(newAnzahl, newName, newPreis, false);
                frame.dispose();
            }
        }
   
        // dispose frame
        if (button == cancelButton) {
            frame.dispose();
        }
    }
}