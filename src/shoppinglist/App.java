package shoppinglist;

public class App {
    
    // entrypoint
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        
        controller.initController();
    }
    
}
