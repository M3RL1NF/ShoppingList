package shoppinglist;
import java.awt.*;
import javax.swing.*;
public class View{
    
    private JFrame frame;
    private JPanel tableContainer;
    private JPanel sidebarContainer;
    private JPanel addNewContainer;
    private JTable table;
    private JLabel labelAnzahl;
    private JTextField inputAnzahl;
    private JLabel labelPreis;
    private JTextField inputPreis;
    private JLabel labelProdukt;
    private JTextField inputProdukt;

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
        
            // Table Container Items
        
            table = new JTable(items, columnNames);
            
        // Sidebar Container
            
        sidebarContainer = new JPanel();
        sidebarContainer.setPreferredSize(new Dimension(175,200));
        sidebarContainer.setVisible(true);
        
            // Sidebar Container Items
        
            labelAnzahl = new JLabel("Anzahl");
            inputAnzahl = new JTextField();
            inputAnzahl.setBounds(100, 20, 165, 25);

            labelPreis = new JLabel("Preis");
            inputPreis = new JTextField();
            inputPreis.setBounds(100, 20, 165, 25);

            labelProdukt = new JLabel("Produkt");
            inputProdukt = new JTextField();
            inputProdukt.setBounds(100, 20, 165, 25);
            
        // addNew Container 
            
        addNewContainer = new JPanel();
        addNewContainer.setPreferredSize(new Dimension(100,175));
        addNewContainer.setVisible(true);
        
            // addNew Container Items
        
        
        // frame.add Section
        
        frame.add(tableContainer, BorderLayout.CENTER);
        frame.add(sidebarContainer, BorderLayout.EAST);
        frame.add(addNewContainer, BorderLayout.SOUTH);
        
        // tableContainer.add 
        
        tableContainer.add(table);
        
        // sidebarContainer.add Section

        sidebarContainer.add(labelAnzahl);
        sidebarContainer.add(inputAnzahl);
        sidebarContainer.add(labelPreis);
        sidebarContainer.add(inputPreis);
        sidebarContainer.add(labelProdukt);
        sidebarContainer.add(inputProdukt);
        
        // addNewContainer.add Section
        
        addNewContainer.add(new JButton("11"));
            
            
        tableContainer.setBackground(Color.magenta);
        sidebarContainer.setBackground(Color.GREEN);
        addNewContainer.setBackground(Color.LIGHT_GRAY);
        
        frame.setVisible(true);
    }
        
}