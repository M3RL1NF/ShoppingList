package shoppinglist.model;

import java.io.IOException;

public class ItemsDAO extends DAO {
    // set input and output stream
    public ItemsDAO(String fileName, boolean openForWrite) {
        super(fileName, openForWrite);
    }

    // write items to file
    @Override
    public void write(Object obj) throws IOException {
        if (out != null) {
            Items itemObject = (Items) obj;
            
            out.writeInt(itemObject.itemList.size());

            ItemDAO itemDAO = new ItemDAO(null, out);

            for (Item item : itemObject.itemList) {
                itemDAO.write(item);
            }
        }
    }

    // read items from file
    @Override
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
