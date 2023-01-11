package shoppinglist;


public class Controller {

    public Model model;
    public View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        initView();
    }
    
    public void initView() {

    }
    
    public void initController() {
        Object shoppingList = new Object();
        System.out.println(model.getShoppingListColumns());
        // shoppingList.columns = model.getShoppingListItems();
        // model.createShoppingListFile();
        // view.openFrame(items);
    }

    
}
