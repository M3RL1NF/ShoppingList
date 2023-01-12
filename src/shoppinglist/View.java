package shoppinglist;
import java.awt.*;
import javax.swing.*;
public class View{
    
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JTextField inputAnzahl;
    private JTextField inputProdukt;
    private JTextField inputPreis;
    private JLabel labelAnzahl;
    private JLabel labelProdukt;
    private JLabel labelPreis;
    
    private final String[] columnNames = {"Anzahl", "Produkt", "Preis", "Erledigt"};
        
    private Object[][] items = {
        {1, "Banane", 0.56, false},
        {2, "Apfel", 0.87, false},
        {3, "Gurke", 0.30, false}
    };
    
    public void GUI() {
        frame = new JFrame();
        
        table = new JTable(items, columnNames);
        
        labelAnzahl = new JLabel("Anzahl");
        
        inputAnzahl = new JTextField();
        inputAnzahl.setBounds(100, 20, 165, 25);
        
        
        labelPreis = new JLabel("Preis");
        
        inputPreis = new JTextField();
        inputPreis.setBounds(100, 20, 165, 25);
        
        
        labelProdukt = new JLabel("Produkt");
        
        inputProdukt = new JTextField();
        inputProdukt.setBounds(100, 20, 165, 25);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        panel.setLayout(new GridLayout());
        panel.add(table);
        
        panel.add(labelAnzahl);
        panel.add(inputAnzahl);
        
        panel.add(labelPreis);
        panel.add(inputPreis);
        
        panel.add(labelProdukt);
        panel.add(inputProdukt);

        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shopping List");
        frame.pack();
        frame.setVisible(true);
    }
        
}