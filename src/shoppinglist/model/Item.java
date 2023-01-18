package shoppinglist.model;

public class Item {
    private int id;
    private int anzahl;
    private String name;
    private double preis;
    private boolean erledigt;
    
    // allows reading items from file
    public Item() {}
    
    // create new Item
    public Item(int id, int anzahl, String name, double preis, boolean erledigt) {
        this.id = id;
        this.anzahl = anzahl;
        this.name = name;
        this.preis = preis;
        this.erledigt = erledigt;
    }
    
    // create getter and setter functions for item attributes
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
