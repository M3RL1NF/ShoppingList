package shoppinglist;
import java.awt.*;
import javax.swing.*;
public class View{
    
    private JFrame frame;
    
    private JPanel tableContainer;
    private JPanel sidebarContainer;
    private JPanel addNewContainer;
    
    
    private JScrollPane scrollPane;
    private JTable table;
    
    private JButton Done;
    private JButton Bearbeiten;
    private JButton Delete;
    
    private JLabel labelAnzahl;
    private JTextField inputAnzahl;
    private JLabel labelPreis;
    private JTextField inputPreis;
    private JLabel labelProdukt;
    private JTextField inputProdukt;
    private JButton addButton; 

    
    
    
    
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
        tableContainer.setVisible(true);
        tableContainer.setLayout(new BorderLayout());
        
            // Table Container Items
            
            table = new JTable(items, columnNames);
            
            scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        
        // Sidebar Container
            
        sidebarContainer = new JPanel();
        sidebarContainer.setPreferredSize(new Dimension(175,200));
        sidebarContainer.setVisible(true);
        
            // Sidebar Container Items
        
            Done = new JButton("Done");
            Bearbeiten = new JButton("Bearbeiten");
            Delete = new JButton("Löschen");
            
        // addNew Container 
            
        addNewContainer = new JPanel();
        addNewContainer.setPreferredSize(new Dimension(100,175));
        addNewContainer.setVisible(true);
        
            // addNew Container Items
            
            labelAnzahl = new JLabel("Anzahl");
            inputAnzahl = new JTextField();
            inputAnzahl.setBounds(100, 20, 165, 25);

            labelPreis = new JLabel("Preis");
            inputPreis = new JTextField();
            inputPreis.setBounds(100, 20, 165, 25);

            labelProdukt = new JLabel("Produkt");
            inputProdukt = new JTextField();
            inputProdukt.setBounds(100, 20, 165, 25);
            
            addButton = new JButton("Hinzufügen");
        
        // frame.add Section
        
        frame.add(tableContainer, BorderLayout.CENTER);
        frame.add(sidebarContainer, BorderLayout.EAST);
        frame.add(addNewContainer, BorderLayout.SOUTH);
        
        // tableContainer.add 
        
        tableContainer.add(scrollPane, BorderLayout.CENTER);
        
        // sidebarContainer.add Section
        
        sidebarContainer.add(Done);
        sidebarContainer.add(Bearbeiten);
        sidebarContainer.add(Delete);
        
        // addNewContainer.add Section
        
        addNewContainer.add(labelAnzahl);
        addNewContainer.add(inputAnzahl);
        addNewContainer.add(labelPreis);
        addNewContainer.add(inputPreis);
        addNewContainer.add(labelProdukt);
        addNewContainer.add(inputProdukt);
        addNewContainer.add(addButton);
        
        // Test Settings
            
        tableContainer.setBackground(Color.magenta);
        sidebarContainer.setBackground(Color.GREEN);
        addNewContainer.setBackground(Color.LIGHT_GRAY);
        
        // Frame.setVisible(True);
        
        frame.setVisible(true);
    }
        
}