package shoppinglist;

public class Controller {

    public View view;
    public ItemFile itemFile;

    public Controller(View view, ItemFile itemFile) {
        this.view = view;
        this.itemFile = itemFile;
        initView();
    }
    
    public void initView() {
        // get items from ItemDAO
        // view.GUI();
    }
    
    public void initController() {
        itemFile.checkItemFile();
        itemFile.createItems();
        itemFile.readItems();
    }
    
    public void handleView() {
        
    }
}
