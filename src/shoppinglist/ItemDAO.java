package shoppinglist;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ItemDAO extends DAO {
    
    public ItemDAO(String fileName, boolean openForWrite) {
        super(fileName, openForWrite);
    }

    public ItemDAO(DataInputStream in, DataOutputStream out) {
        super(in, out);
    }

    public void write(Object obj) throws IOException {
        if (out != null) {
            Item item = (Item) obj;
            out.writeInt(item.getId());
            out.writeUTF(item.getName());
            out.writeInt(item.getAnzahl());
            out.writeBoolean(item.getErledigt());
            out.writeDouble(item.getPreis());
        }
    }

    public void read(Object obj) throws IOException {
        if (in != null) {
            Item item = (Item) obj;
            item.setName(in.readUTF());
            item.setAnzahl(in.readInt());
            item.setErledigt(in.readBoolean());
            item.setPreis(in.readDouble());
        }
    }

}