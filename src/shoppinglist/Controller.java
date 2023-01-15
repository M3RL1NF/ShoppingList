package shoppinglist;

import java.io.IOException;

public class Controller {
    
    private final String[] columnNames = {"Anzahl", "Produkt", "Preis", "Erledigt"};
        
    private final Object[][] items = {
        {1, "Banane", 0.56, false},
        {2, "Apfel", 0.87, false},
        {3, "Gurke", 0.30, false}
    };

    public View view;
    public ItemFile itemFile;

    public Controller(View view, ItemFile itemFile) {
        this.view = view;
        this.itemFile = itemFile;
        initView();
    }
    
    public void initView() {
        // view.GUI(this.readItems());
        view.mainGUI(items, columnNames);
    }
    
    public void initController() {
        this.writeItem(1, "gemüse", 1.1, true);
        this.writeItem(1, "obst", 1.1, true);
        this.readItems();
    }
    
    public void writeItem(int anzahl, String name, double preis, boolean erledigt) {
        Item item = new Item(anzahl, name, preis, erledigt);
        Items items = new Items();
        items.add(item);
        
        ItemsDAO dao = new ItemsDAO(itemFile.getFileName(), true);
        
        try {
            dao.write(items);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        dao.close();
    }
    
    // @todo change return type to object
    public void readItems() {
        Items items = new Items();
        ItemsDAO dao = new ItemsDAO(itemFile.getFileName(), false);

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
    }
    
    public void handleView() {
        // @arnekreikebaum event listener hier?
    }
}
