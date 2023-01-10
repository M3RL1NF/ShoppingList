package shoppinglist;

import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;


public class Model{
        
    public void getShoppingListItems() {
        this.checkShoppingListFile();
       
        /* 
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/Shared/crunchify.json"));
            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;
            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
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
