package shoppinglist;

import java.io.IOException;

public class Controller {
    // columnNames is currently hardcoded into the controller
    // @change: (optional) outsource to own function ItemColumns.java
    private final String[] columnNames = {"Anzahl", "Produkt", "Preis", "Erledigt"};
    
    // this is test data for the view
    // items coming from items.dat need to be formatted into 2 dimensional object array for views jtable
    private final Object[][] items = {
        {1, "Banane", 0.56, false},
        {2, "Apfel", 0.87, false},
        {3, "Gurke", 0.30, false}
    };
    
    // this is a sad attempt to convert the items from items.dat into a 2 dimensional array
    // goal is to work with this 2 dimensional array during runtime instead of arraylist
    // i am not sure this is possible as the reason for arraylists is the variable size
    
    // private final Object[] newitems = this.getItems().itemList.toArray();

    // view instance
    public View view;

    // controller constructor initiating view
    public Controller(View view) {
        this.view = view;
        initView();
    }
    
    // load view
    public void initView() {
        // using actual data for view
        // view.GUI(this.readItems(), columnNames);
        
        // using test data for view
        // view.mainGUI(items, columnNames);
    }
    
    // this function is obsolete, I use it to test
    // @change: delete later
    public void initController() {
        // this actually works: creating a new item and storing it in the runtime arraylist
        // this might be useless if we work with runtime object as this is runtime arraylist
        // this.addItem(this.getItems(), 0, "hallo", 0.2, true);
        
        // another sad attempt to convert arraylist to 2 dimensional object array
        // I am currently working on this!
        Object[] newitems = this.getItems().itemList.toArray();                
                
        for(int i=0; i < newitems.length ; i++){
            System.out.println(newitems[i]);
        }
        
        System.out.println(newitems);
    }
    
    // this function will be called from view 
    // adding a new item to the runtime object
    // currently successfully adds item to runtime arraylist
    public void addItem(Items items, int anzahl, String name, double preis, boolean erledigt) {
        Item item = new Item(anzahl, name, preis, erledigt);
        items.add(item);
        
        // storing item in items.dat
        this.setItems(items);
    }
    
    // this function will be called from view
    // deleting an item from the runtime object
    public void deleteItem(Items itemList, int id) {
        // delete item
    }
    
    // this function will be called from view
    // updating an item from the runtime object
    public void updateItem(Items itemList) {
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
