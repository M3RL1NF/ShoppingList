package shoppinglist;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    
    private static final AtomicInteger atomic_id = new AtomicInteger(0); 
    private int id;
    private int anzahl;
    private String name;
    private double preis;
    private boolean erledigt = false;
    
    public Item() {}
    
    public Item(int anzahl, String name, double preis, boolean erledigt) {
        id = id;
        anzahl = anzahl;
        name = name;
        preis = preis;
        erledigt = erledigt;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId() {
        this.id = atomic_id.incrementAndGet();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public boolean getErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean istErledigt) {
        this.erledigt = istErledigt;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
