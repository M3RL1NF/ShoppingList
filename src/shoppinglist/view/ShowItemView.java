package shoppinglist.view;

import shoppinglist.controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

// load main view
public class ShowItemView implements ActionListener {
    public MainController mainController;

    // initiate mainController
    public void initController(MainController mainController) {
        this.mainController = mainController;
    }
    
    private JFrame      frame;
    private JPanel      tableContainer;
    private JPanel      functionContainer;
    private JScrollPane tableScrollPane;
    private JTable      table;
    private JButton     doneButton;
    private JButton     changeButton;
    private JButton     removeButton;
    private JButton     addButton;
    
    public void GUI(TableModel tableModel) {
        // create main frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Shopping List");
        frame.setLayout(new BorderLayout());
        frame.setSize(800,650);

        // create table container
        tableContainer = new JPanel();
        tableContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
        tableContainer.setLayout(new BorderLayout());

        // create table
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

        // create function container
        functionContainer = new JPanel();
        functionContainer.setPreferredSize(new Dimension(160,0));

        // create buttons
        doneButton   = new JButton("Erledigt");
        doneButton.addActionListener(this);
        doneButton.setPreferredSize(new Dimension(150,30));

        addButton    = new JButton("Hinzufügen");
        addButton.addActionListener(this);
        addButton.setPreferredSize(new Dimension(150,30));

        changeButton = new JButton("Bearbeiten");
        changeButton.addActionListener(this);
        changeButton.setPreferredSize(new Dimension(150,30));

        removeButton = new JButton("Löschen");
        removeButton.addActionListener(this);
        removeButton.setPreferredSize(new Dimension(150,30));

        // add containers to frame
        frame.add(tableContainer, BorderLayout.CENTER);
        frame.add(functionContainer, BorderLayout.EAST);

        // add table pane to table container
        tableContainer.add(tableScrollPane, BorderLayout.CENTER);

        // add buttons to function container
        functionContainer.add(doneButton);
        functionContainer.add(addButton);
        functionContainer.add(changeButton);
        functionContainer.add(removeButton);

        // show frame
        frame.setVisible(true);
    }
    
    // create checkbox render instance
    CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();

    // return boolean class
    public Class<?> getColumnClass(int columnIndex) {
       return Boolean.class;
    }

    // create checkbox render class for table boolean presentation
    public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }

            setSelected((value != null && ((Boolean) value)));
            return this;
        }
    }

    // button functions
    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        // update item
        if (button == doneButton || button == changeButton) {
            if (table.getSelectedRow() == -1) {
                this.showSelectArticleDialog();
            } else {
                int id           = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);
                int anzahl       = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 1);
                String name      = (String)  table.getModel().getValueAt(table.getSelectedRow(), 2);
                double preis     = (Double)  table.getModel().getValueAt(table.getSelectedRow(), 3);
                boolean erledigt = (Boolean) table.getModel().getValueAt(table.getSelectedRow(), 4);

                // update erledigt or all values
                if (button == doneButton) {
                    mainController.updateItem(id, anzahl, name, preis, !erledigt);
                } else {
                    ChangeItemView changeItems = new ChangeItemView(mainController, id, anzahl, name, preis, erledigt);
                    changeItems.GUI();
                }
                
            }
        }

        // add item
        if (button == addButton) {
            AddItemView addItems = new AddItemView(mainController);
            addItems.GUI();
        }

        // delete item
        if (button == removeButton) {
            if (table.getSelectedRow() == -1){
                this.showSelectArticleDialog();
            } else {
                int id = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0);
                mainController.deleteItem(id);
            }
        }
    }
    
    // show select article dialog
    public void showSelectArticleDialog() {
        JOptionPane.showMessageDialog(frame, "Bitte wählen sie einen Artikel aus!");
    }
}

    
