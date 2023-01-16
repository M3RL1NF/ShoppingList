package shoppinglist;

public class App {
    
    // entrypoint
    public static void main(String[] args) {
        Items itemList = new Items();
        // @todo merge App.java and Controller.java to Controller.java
        View view = new View();
        
        Controller controller = new Controller(view, itemList);
        
        controller.initController(); 
    }
    
}
