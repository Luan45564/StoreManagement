package src.store.stock;

import src.model.Food;
import src.model.Beverage;
import src.model.Cleaning;
import src.model.Hygiene;

public class StockLoader {
    public static void load(Stock stock) {
        stock.add(new Food(stock.generateId(), "Arroz", 8.90, 50, "12/2025"));
        stock.add(new Food(stock.generateId(), "Feijão",7.90, 40, "06/2025"));
        stock.add(new Food(stock.generateId(), "Macarrão", 4.90, 40, "08/2025"));

        stock.add(new Beverage(stock.generateId(), "Suco de Laranja", 5.90, 30, 500));
        stock.add(new Beverage(stock.generateId(), "Refrigerante", 7.90, 50, 2000));
        stock.add(new Beverage(stock.generateId(), "Água", 2.90, 100, 1500));

        stock.add(new Cleaning(stock.generateId(), "Detergente", 2.90, 100, "Líquido"));
        stock.add(new Cleaning(stock.generateId(), "Sabão em Pó", 8.90, 60, "Pó"));
        stock.add(new Cleaning(stock.generateId(), "Desinfetante", 5.90, 80, "Líquido"));

        stock.add(new Hygiene(stock.generateId(), "Shampoo", 12.90, 40, "Seda"));
        stock.add(new Hygiene(stock.generateId(), "Sabonete", 3.90, 80, "Dove"));
        stock.add(new Hygiene(stock.generateId(), "Creme Dental", 6.90, 60, "Colgate"));
    }
}
