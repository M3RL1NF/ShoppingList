package shoppinglist;

import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

public class Model{
        
    public void getShoppingListItems() {
        this.checkShoppingListFile();
       
        JSONParser parser = new JSONParser();
        
        try (Reader reader = new FileReader("ShoppingList.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
            

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    
    // create, update, delete
    public void setShoppingListItems() {
        // delete all objects
        // safe all incoming objects
    }   
    
    public void checkShoppingListFile() {
        File shoppingList = new File("ShoppingList.json");
        if (!shoppingList.exists()) {
            this.createShoppingListFile();
        }
    }
    
    public void createShoppingListFile() {
        try { 
            FileOutputStream fileOut = new FileOutputStream("ShoppingList.json");
            fileOut.write(0x4A);
            fileOut.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }

}
