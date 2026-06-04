package src.store;

import src.model.Product;
import src.store.stock.Stock;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity, Stock stock) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity");
            return;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("Unsufficient quantity on stock");
            return;
        }

        if (items.containsKey(product)) {
            items.put(product, items.get(product) + quantity);
        } else{
            items.put(product, quantity);
        }

        stock.removeById(product.getId(), quantity);
    }

    public void removeProduct(Product product, int quantity, Stock stock) {
        if (!items.containsKey(product)) {
            System.out.println("This product was not found in the cart");
            return;
        }

        if (quantity >= items.get(product)) {
            stock.add(product);
            stock.removeById(product.getId(), 0);
            items.remove(product);
        } else {
            items.put(product, items.get(product) - quantity);
            product.setQuantity(product.getQuantity() + quantity);
        }        
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        } else {
            items.forEach(
                (product, quantity) -> System.out.println("%s %dx".formatted(product.getName(), quantity))
            );
        }
    }

    public double getTotal() {
        return items.entrySet().stream().mapToDouble(
            entry -> entry.getKey().getPrice() * entry.getValue()
        ).sum();
    }
}
