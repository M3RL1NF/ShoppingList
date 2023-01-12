package shoppinglist;

public class App {
    
    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        View view = new View();
        Controller controller = new Controller(shoppingList, view);
        
        controller.initController();
    }
    
}
