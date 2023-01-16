package shoppinglist;

import java.io.IOException;

public class ItemsDAO extends DAO {

    public Items itemList;
    private final int itemListSize;
    
    public ItemsDAO(String fileName, boolean openForWrite, Items itemList, int itemListSize) {
        super(fileName, openForWrite);
        this.itemList = itemList;
        this.itemListSize = itemListSize;
    }

    public void write(Object obj) throws IOException {
        if (out != null) {
            Items itemObject = (Items) obj;
            
            System.out.println(itemList);
            
            out.writeInt(itemListSize);

            ItemDAO itemDAO = new ItemDAO(null, out);

            for (Item item : itemObject.itemList) {
                itemDAO.write(item);
            }
        }
    }

    public void read(Object obj) throws IOException {
        if (in != null) {
            Items itemObject = (Items) obj;
            
            int itemCount = in.readInt();

            ItemDAO itemDAO = new ItemDAO(in, null);
            for (int i = 0; i < itemCount; ++i) {
                Item item = new Item();
                itemDAO.read(item);
                itemObject.add(item);
            }
        }
    }
}
