package shoppinglist;
import javax.swing.*;

public class View {
    
    private JFrame frame;
    
    public void openFrame() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Einkaufsliste");
        
        frame.setSize(1920,1080);
        frame.setVisible(true);
        frame.setTitle("Einkaufsliste");
        frame.pack();
        // frame.add(panel, BorderLayout.CENTER);
        
        panel.add(label);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        // panel.setLayout(new GridLayout(0, 1));
        
        String[] columnNames = {"Anzahl",
                        "Produkt",
                        "Preis",
                        "Erledigt",
                        "Bearbeiten"};
        
      /*
        
          Object[][] data = {
    {"Kathy", [][] "Smith",
     "Snowboarding", new Integer(5), new Boolean(false)},
    {"John", "Doe",
     "Rowing", new Integer(3), new Boolean(true)},
    {"Sue", "Black",
     "Knitting", new Integer(2), new Boolean(false)},
    {"Jane", "White",
     "Speed reading", new Integer(20), new Boolean(true)},
    {"Joe", "Brown",
     "Pool", new Integer(10), new Boolean(false)}
};

        
        JTable table = new JTable(data, columnNames);
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
            
        */
    }
 
}
