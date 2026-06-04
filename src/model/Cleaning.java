package src.model;

public class Cleaning extends Product {
    private String type;

    public Cleaning(int id, String name, double price, int quantity, String type) {
        super(id, name, price, quantity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "%s | Type: %s".formatted(super.toString(), type);
    }
}
