package shoppinglist;


public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        initView();
    }
    
    public void initView() {

    }
    
    public void initController() {
        model.getShoppingListItems();
        // model.createShoppingListFile();
        // view.openFrame();
    }

    
}
