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

        for (Product p : cart.getItems().keySet()) {
            if (p.getId() == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("This product was not found");
            return;
        }

        int quantity = 0;

        while (quantity <= 0) {
            System.out.print("Quantity: ");
            quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid quantity, try again: ");
            }
        }

        cart.removeProduct(selected, quantity, stock);
    }

    private static void displayCart() {
        cart.displayCart();

        if (cart.getItems().isEmpty()) {
            return;
        }

        System.out.println("1. Remover Pedido");
        System.out.println("0. Voltar");

        System.out.println("Escolha: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> removeFromCart();
            case 0 -> {}
            default -> System.out.println("Invalid option, try again: ");
        }
    }

    private static void checkout() {
        cart.displayCart();

        System.out.println("\nTotal: R$ %.2f".formatted(cart.getTotal()));

        System.out.println("1. Confirmar Compra");
        System.out.println("2. Voltar");
        System.out.println("0. Encerrar Programa");

        System.out.print("Escolha: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Your purchase has been completed, thank you for coming here!");
                cart = new Cart();
            }
            case 2 -> System.out.println("Going back to the menu...");
            case 0 -> {
                System.out.println("Shutting down the system, see you later!");
                System.exit(0);
            }
            default -> System.out.println("Invalid option");
        }
    }

    private static void menu() {
        int option = -1;

        while (option != 0) {
            System.out.println("-".repeat(80));
            System.out.println("Supermercado");
            System.out.println("-".repeat(80));

            System.out.println("1. Fazer Compras");
            System.out.println("2. Ver Carrinho");
            System.out.println("3. Finalizar Compra");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> addToCart();
                case 2 -> displayCart();
                case 3 -> checkout();
                case 0 -> System.out.println("See you later!");
                default -> {
                    System.out.println("Invalid option, try again: ");
                    option = -1;
                }
            }
        }
    }
}
