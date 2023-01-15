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
    
    private JFrame addframe;
    private JPanel addPanel;
    private JTextArea a;
    private JTextArea b;
    private JTextArea c;
    private JLabel aL;
    private JLabel bL;
    private JLabel cL;
    private JButton addItemButton;
    
    public void addGUI() {
        
        addframe = new JFrame();
        addframe.setTitle("Fügen sie einen Artikel hinzu!");
        addframe.setSize(500,500);
        
        addPanel = new JPanel();
        addframe.add(addPanel);
        addPanel.setLayout(null);
        
        aL = new JLabel("Anzahl: ");
        aL.setBounds(10,80,20,5);
        addPanel.add(aL);
        
        a = new JTextArea();
        a.setBounds(100,20,165,25);
        addPanel.add(a);
        
        b = new JTextArea();
        c = new JTextArea();
        
        bL = new JLabel("Artikel: ");
        cL = new JLabel("Preis: ");
        
        addItemButton = new JButton("Hinzufügen");
            
        addframe.setVisible(true);
        
    }
    
    public void changeGUI() {
        
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
            // change()
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