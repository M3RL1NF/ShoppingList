package shoppinglist;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    private static final AtomicInteger Atomic_id = new AtomicInteger(0); 
    private final int Id;
    private int Anzahl;
    private String Name;
    private double Preis;
    private boolean Erledigt = false;
    
    // item constructor requires 5 values
    public Item(int Anzahl, String Name, double Preis, boolean Erledigt) {
        Id = Atomic_id.incrementAndGet();
        Anzahl = Anzahl;
        Name = Name;
        Preis = Preis;
        Erledigt = Erledigt;
    }
    
    // create an item with the values from view
    public Object createItem(int Anzahl, String Name, double Preis, boolean Erledigt) {
        Item item = new Item(Anzahl, Name, Preis, Erledigt);
        return item;
    }
}
