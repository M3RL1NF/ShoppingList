package shoppinglist;

public class ShoppingListDAO /*  implements Dao<ShoppingList> */{
    ShoppingListDAO shoppingList = new ShoppingListDAO();
    
    public ShoppingListDAO() {
        
    }

    public void write() {
        ShoppingList shoppingList = new ShoppingList();
    }
    
    public void read() {
       /*
        ShoppingList shoppingList = new ShoppingList();
        ShoppingListDAO dao = new ShoppingListDAO("ShoppingList.dat", false);
        dao.read(shoppingList);
        dao.close();
       */
    }

   
}
