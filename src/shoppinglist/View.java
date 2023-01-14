package shoppinglist;
import java.awt.*;
import javax.swing.*;
public class View{
    
    private JFrame frame;
    private JPanel tableContainer;
    private JPanel functionContainer;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton doneButton;
    private JButton changeButton;
    private JButton removeButton;
    private JButton addButton;
    
    // Button Dimensionen
    private int buttonHeight = 30;
    private int buttonWidth = 150;
    
    // MockUp Daten

    private final String[] columnNames = {"Anzahl", "Produkt", "Preis", "Erledigt"};
        
    private final Object[][] items = {
        {1, "Banane", 0.56, false},
        {2, "Apfel", 0.87, false},
        {3, "Gurke", 0.30, false}
    };
    
    public void GUI() {
        
        // Frame
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shopping List");
        frame.setLayout(new BorderLayout());
        frame.setSize(800,650);
        
        // Table Container
        
        tableContainer = new JPanel();
        tableContainer.setPreferredSize(new Dimension(100,175));
        tableContainer.setLayout(new BorderLayout());
        
            // Table Container Items
            
            table = new JTable(items, columnNames);
            scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        
        // functionContainer
            
        functionContainer = new JPanel();
        functionContainer.setPreferredSize(new Dimension(180,0));
        functionContainer.setVisible(true);
        
            // functionContainer Items
        
            doneButton = new JButton("Done");
            doneButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
            addButton = new JButton("Hinzufügen");
            addButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
            changeButton = new JButton("Bearbeiten");
            changeButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
            removeButton = new JButton("Löschen");
            removeButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
            
        
        // frame.add Section
        
        frame.add(tableContainer, BorderLayout.CENTER);
        frame.add(functionContainer, BorderLayout.EAST);
        
        // tableContainer.add 
        
        tableContainer.add(scrollPane, BorderLayout.CENTER);
        
        // functionContainer.add
        
        functionContainer.add(doneButton);
        functionContainer.add(addButton);
        functionContainer.add(changeButton);
        functionContainer.add(removeButton);
        
        // Frame.setVisible(True);
        
        frame.setVisible(true);  
    }
        
}