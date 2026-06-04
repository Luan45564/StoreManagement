package src.model;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        if (price < 0) {
            throw new IllegalArgumentException("The product's price can not be negative.");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("The product's price can not be negative.");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "[%d] %s | R$ %2.f | Stock: %d".formatted(id, name, price, quantity);
    }
}
