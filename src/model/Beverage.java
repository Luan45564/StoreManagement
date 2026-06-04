package src.model;

public class Beverage extends Product {
    private int volume;
    
    public Beverage(int id, String name, double price, int quantity, int volume) {
        super(id, name, price, quantity);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override 
    public String toString() {
        return "%s | Volume: %dml".formatted(super.toString(), volume);
    }
}
