package shoppinglist;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    private static final AtomicInteger Id = new AtomicInteger(0); 
    private int Anzahl;
    private String Name;
    private double Preis;
    private boolean Erledigt = false;
    
    // item constructor requires 5 values
    public Item(AtomicInteger Id, int Anzahl, String Name, double Preis, boolean Erledigt) {
        Id = Id;
        Anzahl = Anzahl;
        Name = Name;
        Preis = Preis;
        Erledigt = Erledigt;
    }
    
    // create an item with the values from view
    public Object createItem(int Anzahl, String Name, double Preis, boolean Erledigt) {
        Item item = new Item(Id, Anzahl, Name, Preis, Erledigt);
        return item;
    }
}
