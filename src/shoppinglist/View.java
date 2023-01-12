package shoppinglist;
import java.awt.*;
import javax.swing.*;

public class View{
    
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    
    private String[] ItemValues = {"Anzahl", "Produkt", "Preis", "Erledigt"};
        
    private Object[][] shoppingListData = {
        {"Anzahl", "Produkt", "Preis", "Erledigt"},
        {"Anzahl", "Produkt", "Preis", "Erledigt"},
        {"Anzahl", "Produkt", "Preis", "Erledigt"}};
    
    public void GUI() {
        frame = new JFrame();
        
        table = new JTable(shoppingListData, ItemValues);
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        panel.setLayout(new GridLayout(0, 2));
        panel.add(table);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shopping List");
        frame.pack();
        frame.setVisible(true);
    }
        
}