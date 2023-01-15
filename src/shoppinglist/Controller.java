package shoppinglist;

public class Controller {

    public View view;
    public ItemFile itemFile;

    public Controller(View view, ItemFile itemFile) {
        this.view = view;
        this.itemFile = itemFile;
        initView();
    }
    
    private final String[] columnNames = {"Anzahl", "Produkt", "Preis", "Erledigt"};
        
    private final Object[][] items = {
        {1, "Banane", 0.56, false},
        {2, "Apfel", 0.87, false},
        {3, "Gurke", 0.30, false}
    };
    
    public void initView() {
        // get items from ItemDAO
        view.mainGUI(items, columnNames);
    }
    
    public void initController() {
        itemFile.checkItemFile();
        itemFile.createItems();
        itemFile.readItems();
    }
    
    public void handleView() {
        
    }
}
