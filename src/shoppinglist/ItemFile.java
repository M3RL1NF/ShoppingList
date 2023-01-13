package shoppinglist;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class ItemFile {
    public void checkItemFile() {
        File itemFile = new File(this.getFileName());
        if (!itemFile.exists()) {
            this.createItemFile();
        }
    }
    
    public void createItemFile() {
        try { 
            FileOutputStream fileOut = new FileOutputStream(this.getFileName());
            BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
            PrintStream out = new PrintStream(bufOut);
            
            fileOut.write(0x4A);
            bufOut.write(0x4A);
            
            fileOut.close();
            bufOut.close();
            out.close();
            
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }
    
    public void createItems() {
        Item item = new Item(1, "String", 1.1, true);
            
        try {
            FileOutputStream fileOut = new FileOutputStream(this.getFileName());
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            // DataOutputStream out = new DataOutputStream(fileOut);
            oos.writeObject(item);
            fileOut.close();
            oos.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }
    
    public void readItems() {
        try {
            FileInputStream fileIn = new FileInputStream(this.getFileName());
            DataInputStream in = new DataInputStream(fileIn);
            
            String s = in.readUTF();
            System.out.println("HALLO " + s);
            in.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }
    
    public void setItems() {
        try {
            FileInputStream fileIn = new FileInputStream(this.getFileName());
            BufferedInputStream bufIn = new BufferedInputStream(fileIn);
            
            int i = fileIn.read();
            
            if (i >= 0) {
                byte b = (byte)i;
                System.out.println("Hallo " + b + " " + i);
            }
            else {
            }
            
            fileIn.close();
            bufIn.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public String getFileName() {
        return "Item.dat";
    }
}


