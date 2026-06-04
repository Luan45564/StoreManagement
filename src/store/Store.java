package src.store;

import java.util.Scanner;

import src.model.Product;
import src.store.stock.Stock;
import src.store.stock.StockLoader;

public class Store {
    private static Stock stock = new Stock();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void openStore() {
        StockLoader.load(stock);
        menu();
    }

    private static void displayProducts() {
        System.out.println("-".repeat(80));
        System.out.println("Products");
        System.out.println("-".repeat(80));

        stock.getAll().forEach(product -> System.out.println(product));
    }

    private static void addToCart() {
        displayProducts();

        System.out.println("\nProduct's ID: ");
        int id = scanner.nextInt();

        Product selected = null;
        for (Product p : stock.getAll()) {
            if (p.getId() == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("The product was not found");
            return;
        }

        int quantity = 0;

        while(quantity <= 0 || quantity > selected.getQuantity()) {
            System.out.println("Quantidade: ");
            quantity = scanner.nextInt();

            if (quantity <= 0 || quantity > selected.getQuantity()) {
                System.out.println("Invalid quantity, try again: ");
            }
        }

        cart.addProduct(selected, quantity, stock);
    }

    private static void removeFromCart() {
        cart.displayCart();

        System.out.print("\nProduct's ID: ");
        int id = scanner.nextInt();

        Product selected = null;

        for (Product p : stock.getAll()) {
            if (p.getId() == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("This product was not found");
        }
    }

    private static void menu() {
        int option = -1;

        while (option != 0) {
            System.out.println("-".repeat(80));
            System.out.println("Supermercado");
            System.out.println("-".repeat(80));

            System.out.println("1. Ver Produtos");
            System.out.println("2. Ver Carrinho");
            System.out.println("3. Finalizar Compra");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");

            option = scanner.nextInt();
        }
    }
}
