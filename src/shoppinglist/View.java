package shoppinglist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.table.TableModel;
import javax.swing.*;

public class View implements ActionListener{
    private Controller controller;

    public void initController(Controller controller) {
        this.controller = controller;
    }
// mainGUI Declarations
    
    private JFrame mainFrame;
    private JPanel tableContainer;
    private JPanel functionContainer;
    private JScrollPane tableScrollPane;
    private JTable table;
    private JButton doneButton;
    private JButton changeButton;
    private JButton removeButton;
    private JButton addButton;
    
    public void mainGUI(TableModel tableModel) {
        
        System.out.println(tableModel);
        
    // mainFrame
    
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Shopping List");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(800,650);
        
    // Table Container
        
        tableContainer = new JPanel();
        tableContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
        tableContainer.setLayout(new BorderLayout());
        
    // Table Container Items

        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        tableScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        
    // functionContainer
            
        functionContainer = new JPanel();
        functionContainer.setPreferredSize(new Dimension(160,0));
        functionContainer.setVisible(true);
        
    // functionContainer Items
        
            doneButton = new JButton("Done");
            doneButton.addActionListener(this);
            doneButton.setPreferredSize(new Dimension(150,30));
            
            addButton = new JButton("Hinzufügen");
            addButton.addActionListener(this);
            addButton.setPreferredSize(new Dimension(150,30));
            
            changeButton = new JButton("Bearbeiten");
            changeButton.addActionListener(this);
            changeButton.setPreferredSize(new Dimension(150,30));
            
            removeButton = new JButton("Löschen");
            removeButton.addActionListener(this);
            removeButton.setPreferredSize(new Dimension(150,30));
            
        
    // frame.add Section
        
        mainFrame.add(tableContainer, BorderLayout.CENTER);
        mainFrame.add(functionContainer, BorderLayout.EAST);
        
    // tableContainer.add 
        
        tableContainer.add(tableScrollPane, BorderLayout.CENTER);
        
    // functionContainer.add
        
        functionContainer.add(doneButton);
        functionContainer.add(addButton);
        functionContainer.add(changeButton);
        functionContainer.add(removeButton);
        
    // Frame.setVisible(True);
        
        mainFrame.setVisible(true);
    };
    
// addGUI Declarations
    
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
    
    public void addGUI() {
        
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
    
    private JFrame changeFrame;
    private JPanel changePanel;
    private JTextField changeinputAnzahl;
    private JLabel changelabelAnzahl;
    private JTextField changeinputName;
    private JLabel changelabelName;
    private JTextField changeinputPreis;
    private JLabel changelabelPreis;
    private JButton changeItemButton;
    private JButton changecancelButton;
    
    public void changeGUI() {
        
        changeFrame = new JFrame();
        changePanel = new JPanel();
        
        changeFrame.setTitle("Bearbeiten.");
        changeFrame.setLocation(new Point(500, 300));
        changeFrame.add(changePanel);
        changeFrame.setSize(new Dimension(313, 300));
        changeFrame.setResizable(false);
        changeFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        changePanel.setLayout(null);
        
        changelabelAnzahl = new JLabel("Anzahl: ");
        changelabelAnzahl.setBounds(50, 7, 70, 20);
        
        changeinputAnzahl = new JTextField(table.getModel().getValueAt(table.getSelectedRow(),1).toString());
        changeinputAnzahl.setBounds(50, 27, 193, 28);
        
        changelabelName = new JLabel("Artikel: ");
        changelabelName.setBounds(50, 55, 70, 20);
        
        changeinputName = new JTextField(table.getModel().getValueAt(table.getSelectedRow(),2).toString());
        changeinputName.setBounds(50, 75, 193, 28);
        
        changelabelPreis = new JLabel("Preis: ");
        changelabelPreis.setBounds(50, 103, 90, 20);
        
        changeinputPreis = new JTextField(table.getModel().getValueAt(table.getSelectedRow(),3).toString());
        changeinputPreis.setBounds(50, 123, 193, 28);
        
        changeItemButton = new JButton("Bearbeiten");
        changeItemButton.addActionListener(this);
        changeItemButton.setBounds(50, 160, 193, 28);
        
        changecancelButton = new JButton("Abbrechen");
        changecancelButton.addActionListener(this);
        changecancelButton.setBounds(50, 195, 193, 28);
        
        changePanel.add(changelabelAnzahl);
        changePanel.add(changeinputAnzahl);
        changePanel.add(changelabelName);
        changePanel.add(changeinputName);
        changePanel.add(changelabelPreis);
        changePanel.add(changeinputPreis);
        changePanel.add(changeItemButton);
        changePanel.add(changecancelButton);
        
        changeFrame.setVisible(true);
    }
    
// Action Listener
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object button = e.getSource();
        
    // mainGUI ActionListerners
        
        if(button == doneButton){
            int id = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);
            int anzahl = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 1);
            String name = (String) table.getModel().getValueAt(table.getSelectedRow(), 2); 
            Double preis = (Double) table.getModel().getValueAt(table.getSelectedRow(), 3);
            
            controller.updateItem(id, anzahl, name, preis, true);
        }
        
        if(button == addButton){
            addGUI();
        }
        
        if(button == changeButton){
            changeGUI();
        }
        
        if(button == removeButton){
            controller.deleteItem((Integer) table.getModel().getValueAt(table.getSelectedRow(), 0));
        }
        
    // addGUI ActionListerners
    
        if(button == addItemButton){
            controller.addItem(Integer.parseInt(addinputAnzahl.getText()), addinputName.getText(), Double.parseDouble(addinputPreis.getText()), false);
            addFrame.dispose();
        }
        
        if(button == addcancelButton){
            addFrame.dispose();
        }
        
    // changeGUI ActionListerners
    
        if(button == changeItemButton){
            controller.updateItem((Integer) table.getModel().getValueAt(table.getSelectedRow(), 0), Integer.parseInt(changeinputAnzahl.getText()), changeinputName.getText(), Double.parseDouble(changeinputPreis.getText()), false);
            changeFrame.dispose();
        }
        
        if(button == changecancelButton){
            changeFrame.dispose();
        }
        
    }    
}