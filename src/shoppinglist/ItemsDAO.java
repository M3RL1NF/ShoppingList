package shoppinglist;

import java.io.IOException;

/**
 * Data Access Object für die Klasse Studenten.
 */
public class ItemsDAO extends DAO {

    public ItemsDAO(String dateiName, boolean openForWrite) {
        super(dateiName, openForWrite);
    }

    public void write(Object obj) throws IOException {
        if (out != null) {
            Items itemObject = (Items) obj;
            
            // Anzahl Studenten speichern:
            out.writeInt(itemObject.itemList.size());

            // Nun die einzelnen Studenten speichern:
            ItemDAO itemDAO = new ItemDAO(null, out);

            for (Item item : itemObject.itemList) {
                itemDAO.write(item);
            }
        }
    }

    public void read(Object obj) throws IOException {
        if (in != null) {
            Items itemObject = (Items) obj;

            // Anzahl Studenten lesen:
            int itemCount = in.readInt();

            // Nun die einzelnen Studenten lesen:
            ItemDAO itemDAO = new ItemDAO(in, null);
            for (int i = 0; i < itemCount; ++i) {
                Item item = new Item();
                itemDAO.read(item);
                itemObject.add(item);
            }
        }
    }
}
