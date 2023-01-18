package shoppinglist.model;

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

    @Override
    public void write(Object obj) throws IOException {
        if (out != null) {
            Item item = (Item) obj;
            out.writeInt(item.getId());
            out.writeInt(item.getAnzahl());
            out.writeUTF(item.getName());
            out.writeDouble(item.getPreis());
            out.writeBoolean(item.getErledigt());
        }
    }
    
    @Override
    public void read(Object obj) throws IOException {
        if (in != null) {
            Item item = (Item) obj;  
            item.setId(in.readInt());
            item.setAnzahl(in.readInt());
            item.setName(in.readUTF());
            item.setPreis(in.readDouble());
            item.setErledigt(in.readBoolean());
        }
    }
}