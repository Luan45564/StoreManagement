package src.model;

public class Food extends Product {
    private String expirationDate;

    public Food(int id, String name, double price, int quantity, String expirationDate) {
        super(id, name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "%s | Expiration Date: %s".formatted(super.toString(),expirationDate);
    }   
}
