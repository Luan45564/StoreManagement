package src.model;

public class Hygiene extends Product{
    private String brand;

    public Hygiene(int id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "%s | Brand: %s".formatted(super.toString(), brand);
    }
}