package shoppinglist.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class DAO {

    protected DataInputStream in;
    protected DataOutputStream out;

    public DAO(String fileName, boolean openForWrite) {
        try {
            if (openForWrite) {
                out = new DataOutputStream(new FileOutputStream(fileName));
            } else {
                in = new DataInputStream(new FileInputStream(fileName));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public DAO(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void close() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
        }
    }

    public abstract void write(Object obj) throws IOException;

    public abstract void read(Object obj) throws IOException;

}
