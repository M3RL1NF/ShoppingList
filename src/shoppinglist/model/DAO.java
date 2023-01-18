package shoppinglist.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class DAO {
    protected DataInputStream in;
    protected DataOutputStream out;

    // set data read and write rules for file interaction
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

    // set data input and output streams
    public DAO(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    // close reader and writer
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

    // create write abstract function
    public abstract void write(Object obj) throws IOException;

    // create read abstract function
    public abstract void read(Object obj) throws IOException;
}
