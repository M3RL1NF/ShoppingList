package shoppinglist.controller;

import shoppinglist.view.*;
import shoppinglist.model.Items;
import shoppinglist.model.Item;
import shoppinglist.model.ItemsDAO;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public final class Controller {
    private final String[] columnNames  = {"Id", "Anzahl", "Name", "Preis in €", "Erledigt"};
    public DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    public Items items;
    public View view;
    
    // set view and items, inititate view
    public Controller(View view, Items items) {
        this.view = view;
        this.items = items;
        initView();
    }
    
    // get items from file, create JTable data
    public void initController() {
        this.getItems();
        this.createTableModel();
    }
    
    // open view with JTable data
    public void initView() {
        view.GUI(tableModel);
    }
    
    // build JTable data
    public void createTableModel(){
        // clear model data before storing
        tableModel.setRowCount(0);
        
        for (int i = 0; i < items.itemList.size(); i++){
            int id           = items.itemList.get(i).getId();
            int anzahl       = items.itemList.get(i).getAnzahl();
            String name      = items.itemList.get(i).getName();
            double preis     = items.itemList.get(i).getPreis();
            boolean erledigt = items.itemList.get(i).getErledigt();

            Object[] data    = {id, anzahl, name, preis, erledigt};
            
            tableModel.addRow(data);
        }
    }
    
    public double getItemSum() {
        return items.getItemSum();
    }
    
    // add item to runtime arraylist
    public void addItem(int anzahl, String name, double preis, boolean erledigt) {
        Item item = new Item(items.setId(), anzahl, name, preis, erledigt);
        
        items.add(item);
        
        this.setItems(items);
        this.initController();
    }
    
    // delete item from runtime arraylist
    public void deleteItem(int id) {
        items.delete(id);
        
        this.setItems(items);
        this.initController();
    }
    
    // update item in runtime arraylist
    public void updateItem(int id, int anzahl, String name, double preis, boolean erledigt) {
        items.update(id, anzahl, name, preis, erledigt);
        
        this.setItems(items);
        this.initController();
    }
    
    // write item/items from runtime arraylist to file
    public void setItems(Items items) {
        ItemsDAO dao = new ItemsDAO("items.dat", true);
        
        try {
            dao.write(items);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        dao.close();
    }
 
    // read item/items from file to runtime arraylist
    public Items getItems() {
        Items itemList  = new Items();
        ItemsDAO dao    = new ItemsDAO("items.dat", false);
        
        try {
            dao.read(itemList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        items.itemList.clear();
        items = itemList;
        
        dao.close();
         
        return items;
    }
}
