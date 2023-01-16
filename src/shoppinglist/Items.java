package shoppinglist;

import java.util.ArrayList;

public class Items {

    public static ArrayList<Item> itemList;
    
    public Items() {
        itemList = new ArrayList<>();
    }

    public void add(Item item) {
        itemList.add(item);
    }
    
    public int size() {
        return itemList.size();
    }
}
