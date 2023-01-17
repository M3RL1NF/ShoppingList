package shoppinglist;

public class App {
    
    // entrypoint
    public static void main(String[] args) {
        // @todo merge App.java and Controller.java to Controller.java
        // this file should become Controller.java and hold all controller functions
        // below class instances become obsolete
        View view = new View();
        Items items = new Items();
        Controller controller = new Controller(view, items);
        
        controller.initController();
        view.initController(controller);

    }
    
}
