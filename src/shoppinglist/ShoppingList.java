package shoppinglist;

import java.util.*;

public class ShoppingList{
    
    public String[] columns = {"ID", "Anzahl", "Name", "Preis", "Erledigt"};
    public Object items = new Object();
    
    public Object getShoppingList() {
        Stack<Object> shoppingList = new Stack<Object>();
        
        shoppingList.add(columns);
        shoppingList.add(items);
        
        return shoppingList;
    }
}

