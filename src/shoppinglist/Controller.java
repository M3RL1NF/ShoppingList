package shoppinglist;

import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Controller {
    // columnNames is currently hardcoded into the controller
    // @change: (optional) outsource to own function ItemColumns.java
    private final String[] columnNames = {"Id", "Anzahl", "Name", "Preis", "Erledigt"};
    
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    public Items items;
    
    public void createTableModel(){
        for (int i = 0; i < this.getItems().itemList.size(); i++){
            int id = this.getItems().itemList.get(i).getId();
            int anzahl = this.getItems().itemList.get(i).getAnzahl();
            String name = this.getItems().itemList.get(i).getName();
            double preis = this.getItems().itemList.get(i).getPreis();
            boolean erledigt = this.getItems().itemList.get(i).getErledigt();

            Object[] data = {id, anzahl, name, preis, erledigt};

            tableModel.addRow(data);
        }
    }
    
    // view instance
    public View view;

    // controller constructor initiating view
    public Controller(View view, Items items) {
        this.view = view;
        this.items = items;
        initView();
    }
    
    // load view
    public void initView() {
        // using test data for view
        view.mainGUI(tableModel);
    }
    
    public void initController() {
        this.createTableModel();
    }
    
    // this function will be called from view 
    // adding a new item to the runtime object
    // currently successfully adds item to runtime arraylist
    public void addItem(int anzahl, String name, double preis, boolean erledigt) {
        Item item = new Item(anzahl, name, preis, erledigt);
        
        for (int i = 0; i < this.getItems().itemList.size(); i++) {
            items.add(this.getItems().itemList.get(i));
        }
        
        items.add(item);
        
        this.setItems(items);
        
        this.createTableModel();
    }
    
    // this function will be called from view
    // deleting an item from the runtime object
    public void deleteItem(int id) {
        // delete item
    }
    
    // this function will be called from view
    // updating an item from the runtime object
    public void updateItem(int id, int anzahl, String name, double preis, boolean erledigt) {
        // update item
    }
    
    // storing items in the items.dat via dao
    public void setItems(Items items) {
        ItemsDAO dao = new ItemsDAO("items.dat", true);
        
        try {
            dao.write(items);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        dao.close();
    }
 
    // retrieving item from items.dat via dao
    // retrieve with items.itemList.get(0).getPreis()
    public Items getItems() {
        Items items = new Items();
        
        ItemsDAO dao = new ItemsDAO("items.dat", false);
        
        try {
            dao.read(items);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        dao.close();
         
        return items;
    }
}
