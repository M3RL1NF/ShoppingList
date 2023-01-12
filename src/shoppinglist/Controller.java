package shoppinglist;

public class Controller {

    public View view;

    public Controller(View view) {
        this.view = view;
        initView();
    }
    
    public void initView() {
        // get items from ItemDAO
        view.GUI();
    }
    
    public void initController() {
        
    }
    
    public void handleView() {
        
    }
}
