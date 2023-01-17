package shoppinglist;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    
    private static final AtomicInteger atomic_id = new AtomicInteger(0); 
    private int id;
    private int anzahl;
    private String name;
    private double preis;
    private boolean erledigt;
    
    public Item() {}
    
    public Item(int anzahl, String name, double preis, boolean erledigt) {
        this.id = id;
        this.anzahl = anzahl;
        this.name = name;
        this.preis = preis;
        this.erledigt = erledigt;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId() {
        this.id = atomic_id.incrementAndGet();
    }
    
    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    
    public boolean getErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean istErledigt) {
        this.erledigt = istErledigt;
    }

}
