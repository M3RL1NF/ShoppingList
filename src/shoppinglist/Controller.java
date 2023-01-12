package shoppinglist;


public class Controller {

    public ShoppingList shoppingList;
    public View view;

    public Controller(ShoppingList shoppingList, View view) {
        this.shoppingList = shoppingList;
        this.view = view;
        initView();
    }
    
    public void initView() {
        view.GUI();
    }
    
    public void initController() {

    }
    
}
