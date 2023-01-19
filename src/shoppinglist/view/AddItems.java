package shoppinglist.view;

import java.awt.Dimension;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import shoppinglist.controller.*;

public class AddItems implements ActionListener{
    
    public Controller controller;
    
    public AddItems(Controller controller){
        this.controller = controller;
    }
    
    private JFrame addFrame;
    private JPanel addPanel;
    private JTextField addinputAnzahl;
    private JLabel addlabelAnzahl;
    private JTextField addinputName;
    private JLabel addlabelName;
    private JTextField addinputPreis;
    private JLabel addlabelPreis;
    private JButton addItemButton;
    private JButton addcancelButton;
    
    public void GUI(){
        addFrame = new JFrame();
        addPanel = new JPanel();
        
        addFrame.setTitle("Fügen sie einen Artikel hinzu!");
        addFrame.setLocation(new Point(500, 300));
        addFrame.add(addPanel);
        addFrame.setSize(new Dimension(313, 300));
        addFrame.setResizable(false);
        addFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        addPanel.setLayout(null);
        
        addlabelAnzahl = new JLabel("Anzahl: ");
        addlabelAnzahl.setBounds(50, 7, 70, 20);
        
        addinputAnzahl = new JTextField();
        addinputAnzahl.setBounds(50, 27, 193, 28);
        
        addlabelName = new JLabel("Artikel: ");
        addlabelName.setBounds(50, 55, 70, 20);
        
        addinputName = new JTextField();
        addinputName.setBounds(50, 75, 193, 28);
        
        addlabelPreis = new JLabel("Preis: ");
        addlabelPreis.setBounds(50, 103, 90, 20);
        
        addinputPreis = new JTextField();
        addinputPreis.setBounds(50, 123, 193, 28);
        
        addItemButton = new JButton("Hinzufügen");
        addItemButton.addActionListener(this);
        addItemButton.setBounds(50, 160, 193, 28);
        
        addcancelButton = new JButton("Abbrechen");
        addcancelButton.addActionListener(this);
        addcancelButton.setBounds(50, 195, 193, 28);
        
        addPanel.add(addlabelAnzahl);
        addPanel.add(addinputAnzahl);
        addPanel.add(addlabelName);
        addPanel.add(addinputName);
        addPanel.add(addlabelPreis);
        addPanel.add(addinputPreis);
        addPanel.add(addItemButton);
        addPanel.add(addcancelButton);
        
        addFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object button = e.getSource();
    
        if(button == addItemButton){
            int newAnzahl = Integer.parseInt(addinputAnzahl.getText());
            String newName = addinputName.getText();
            double newPreis = Double.parseDouble(addinputPreis.getText());
            
            controller.addItem(newAnzahl, newName, newPreis, false);
            addFrame.dispose();
        }
        
        if(button == addcancelButton){
            addFrame.dispose();
        }
    }
}