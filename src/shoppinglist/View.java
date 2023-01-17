package shoppinglist;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View implements ActionListener{
    
// Button Dimensionen
    
    private int buttonHeight = 30;
    private int buttonWidth = 150;
    
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
    
    public void mainGUI(Object[][] items, String[] columnNames) {
        
    // mainFrame
    
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Shopping List");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(800,650);
        
    // Table Container
        
        tableContainer = new JPanel();
        tableContainer.setPreferredSize(new Dimension(100,175));
        tableContainer.setLayout(new BorderLayout());
        
    // Table Container Items
            
            table = new JTable(items, columnNames);
            tableScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        
    // functionContainer
            
        functionContainer = new JPanel();
        functionContainer.setPreferredSize(new Dimension(180,0));
        functionContainer.setVisible(true);
        
    // functionContainer Items
        
            doneButton = new JButton("Done");
            doneButton.addActionListener(this);
            doneButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
            addButton = new JButton("Hinzufügen");
            addButton.addActionListener(this);
            addButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
            changeButton = new JButton("Bearbeiten");
            changeButton.addActionListener(this);
            changeButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
            removeButton = new JButton("Löschen");
            removeButton.addActionListener(this);
            removeButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
        
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
    private JTextArea addinputAnzahl;
    private JLabel addlabelAnzahl;
    private JTextArea addinputName;
    private JLabel addlabelName;
    private JTextArea addinputPreis;
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
        
        addinputAnzahl = new JTextArea();
        addinputAnzahl.setBounds(50, 27, 193, 28);
        
        addlabelName = new JLabel("Artikel: ");
        addlabelName.setBounds(50, 55, 70, 20);
        
        addinputName = new JTextArea();
        addinputName.setBounds(50, 75, 193, 28);
        
        
        addlabelPreis = new JLabel("Preis: ");
        addlabelPreis.setBounds(50, 103, 90, 20);
        
        addinputPreis = new JTextArea();
        addinputPreis.setBounds(50, 123, 193, 28);
        
        addItemButton = new JButton("Hinzufügen");
        addItemButton.setBounds(50, 160, 193, 28);
        
        addcancelButton = new JButton("Abbrechen");
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
    private JTextArea changeinputAnzahl;
    private JLabel changelabelAnzahl;
    private JTextArea changeinputName;
    private JLabel changelabelName;
    private JTextArea changeinputPreis;
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
        
        changeinputAnzahl = new JTextArea();
        changeinputAnzahl.setBounds(50, 27, 193, 28);
        
        changelabelName = new JLabel("Artikel: ");
        changelabelName.setBounds(50, 55, 70, 20);
        
        changeinputName = new JTextArea();
        changeinputName.setBounds(50, 75, 193, 28);
        
        changelabelPreis = new JLabel("Preis: ");
        changelabelPreis.setBounds(50, 103, 90, 20);
        
        changeinputPreis = new JTextArea();
        changeinputPreis.setBounds(50, 123, 193, 28);
        
        changeItemButton = new JButton("Bearbeiten");
        changeItemButton.setBounds(50, 160, 193, 28);
        
        changecancelButton = new JButton("Abbrechen");
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
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object button = e.getSource();
        
    // mainGUI ActionListerners
        
        if(button == doneButton){
            // done()
            System.out.println("DONE");
        }
        
        if(button == addButton){
            addGUI();
            System.out.println("ADD");
        }
        
        if(button == changeButton){
            changeGUI();
            System.out.println("CHANGE");
        }
        
        if(button == removeButton){
            // remove()
            System.out.println("REMOVE");
        }
        
    // addGUI ActionListerners

    // changeGUI ActionListerners
        
        
    }        
}