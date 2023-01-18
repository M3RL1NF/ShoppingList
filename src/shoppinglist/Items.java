package shoppinglist;

import java.util.ArrayList;

public class Items {

    ArrayList<Item> itemList = new ArrayList<>();

    public void add(Item item) {
        itemList.add(item);
    }
    
    public int setId() {
        if (!itemList.isEmpty()) {
            return itemList.get(itemList.size() - 1).getId() + 1;
        } else {
           return 1;
        }
    }
    
    public void update(int id, int anzahl, String name, double preis, boolean erledigt) {
        for (int i=0; i < itemList.size(); i++) {
            if (itemList.get(i).getId() == id) {
                itemList.get(i).setAnzahl(anzahl);
                itemList.get(i).setName(name);
                itemList.get(i).setPreis(preis);
                itemList.get(i).setErledigt(erledigt);
            }
        }
    }
    
    public void delete(int id) {
        for (int i=0; i < itemList.size(); i++) {
            if (itemList.get(i).getId() == id) {
                itemList.remove(i);
            }
        }
    }
}
