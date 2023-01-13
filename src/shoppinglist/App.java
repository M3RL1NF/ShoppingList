package shoppinglist;

public class App {
    
    // entrypoint
    public static void main(String[] args) {
        View view = new View();
        ItemFile itemFile = new ItemFile();
        Controller controller = new Controller(view, itemFile);
        
        controller.initController();
    }
    
}
