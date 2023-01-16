package shoppinglist;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    
    private final String[] columnNames = {"Anzahl", "Produkt", "Preis", "Erledigt"};
    private ArrayList<Item> itemx = new ArrayList<>();
    
    private final Object[][] items = {
        {1, "Banane", 0.56, false},
        {2, "Apfel", 0.87, false},
        {3, "Gurke", 0.30, false}
    };

    public View view;
    public Items itemList;

    public Controller(View view, Items itemList) {
        this.view = view;
        this.itemList = itemList;
        initView();
    }
    
    public void initView() {
        // view.GUI(this.readItems());
        view.mainGUI(items, columnNames);
    }
    
    public void initController() {
        this.writeItems(0, "name", 0, true);
        this.writeItems(0, "name", 0, true);
        this.writeItems(0, "name", 0, true);
        
        this.readItems(); 
    }
    
    public void writeItems(int anzahl, String name, double preis, boolean erledigt) {
        Item item = new Item(anzahl, name, preis, erledigt);
        
        itemList.add(item);
        
        ItemsDAO dao = new ItemsDAO("items.dat", true, itemList, itemList.size());
        
        try {
            dao.write(itemList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        dao.close();
    }
 
    // @todo change return type to object
    public ArrayList<Item> readItems() {
        Items items = new Items();
        
        ItemsDAO dao = new ItemsDAO("items.dat", false, itemList, itemList.size());
        
        try {
            dao.read(items);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        dao.close();
        
        for (Item item : items.itemList) {
            System.out.println(item.getId());
            System.out.println(item.getName());
            System.out.println(item.getAnzahl());
            System.out.println(item.getErledigt());
            System.out.println(item.getPreis());
        }
        
        return items.itemList;
    }
    
    public void handleView() {
        // @arnekreikebaum event listener hier?
    }
}
