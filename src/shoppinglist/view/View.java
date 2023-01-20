package shoppinglist.view;

import shoppinglist.controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.table.TableModel;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class View implements ActionListener{
    public Controller controller;

    public void initController(Controller controller) {
        this.controller = controller;
    }
    
    // mainGUI Declarations
    
    private JFrame frame;
    private JPanel tableContainer;
    private JPanel functionContainer;
    private JScrollPane tableScrollPane;
    private JTable table;
    private JButton doneButton;
    private JButton changeButton;
    private JButton removeButton;
    private JButton addButton;
    
    public void GUI(TableModel tableModel) {
        
    // mainFrame
    
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shopping List");
        frame.setLayout(new BorderLayout());
        frame.setSize(800,650);
        
    // Table Container
        
        tableContainer = new JPanel();
        tableContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
        tableContainer.setLayout(new BorderLayout());
        
    // Table Container Items


        
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().setReorderingAllowed(false);
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(4).setCellRenderer(checkBoxRenderer);
        table.setRowHeight(40);
        table.setShowVerticalLines(false);
        table.setFont(new Font(Font.DIALOG,  Font.ITALIC, 15));
        table.getColumnModel().setColumnMargin(0);
        
        tableScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        
    // functionContainer
            
        functionContainer = new JPanel();
        functionContainer.setPreferredSize(new Dimension(160,0));
        functionContainer.setVisible(true);
        
    // functionContainer Items
        
        doneButton = new JButton("Erledigt");
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
        
        frame.add(tableContainer, BorderLayout.CENTER);
        frame.add(functionContainer, BorderLayout.EAST);
        
    // tableContainer.add 
        
        tableContainer.add(tableScrollPane, BorderLayout.CENTER);
        
    // functionContainer.add
        
        functionContainer.add(doneButton);
        functionContainer.add(addButton);
        functionContainer.add(changeButton);
        functionContainer.add(removeButton);
        
    // Frame.setVisible(True);
        
        frame.setVisible(true);
    };

    CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
            
    public Class<?> getColumnClass(int columnIndex) {
       return Boolean.class;
    }
    
    public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {


          @Override
          public Component getTableCellRendererComponent(JTable table, Object value,
              boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
              setForeground(table.getSelectionForeground());
              //super.setBackground(table.getSelectionBackground());
              setBackground(table.getSelectionBackground());
            } else {
              setForeground(table.getForeground());
              setBackground(table.getBackground());
            }
            setSelected((value != null && ((Boolean) value).booleanValue()));
            return this;
          }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object button = e.getSource();
                
        if(button == doneButton){
            if(table.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(frame, "Bitte wählen sie einen Artikel aus!");
            } else {
                int id = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);
                int anzahl = (Integer)table.getModel().getValueAt(table.getSelectedRow(), 1);
                String name = (String) table.getModel().getValueAt(table.getSelectedRow(), 2);
                Double preis = (Double) table.getModel().getValueAt(table.getSelectedRow(), 3);
                boolean erledigt = (boolean) table.getModel().getValueAt(table.getSelectedRow(), 4);
                
                controller.updateItem(id, anzahl, name, preis, !erledigt);
            }
        }
            
        if(button == addButton){
            AddItems addItems = new AddItems(controller);
            addItems.GUI();
        }
        
        if(button == changeButton){
            if(table.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(frame, "Bitte wählen sie einen Artikel aus!");
            } else {
                int id = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);
                int anzahl = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 1);
                String name = (String) table.getModel().getValueAt(table.getSelectedRow(), 2);
                Double preis = (Double) table.getModel().getValueAt(table.getSelectedRow(), 3);
                boolean erledigt = (boolean) table.getModel().getValueAt(table.getSelectedRow(), 4);
                
                ChangeItems changeItems = new ChangeItems(controller, id, anzahl, name, preis, erledigt);
                changeItems.GUI();
            }
        }
        
        if(button == removeButton){
            if(table.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(frame, "Bitte wählen sie einen Artikel aus!");
            } else {
                int id = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);
                controller.deleteItem(id);
            }
        }
    }    
}