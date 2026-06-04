package src.store.stock;

import src.model.Product;
import src.repository.Repository;;

public class Stock extends Repository<Product> {
    public void removeById(int id, int quantity) {
        for (Product p : getAll()) {
            if (p.getId() == id) {
                p.setQuantity(p.getQuantity() - quantity);

                return;
            }
        }
    }
}
