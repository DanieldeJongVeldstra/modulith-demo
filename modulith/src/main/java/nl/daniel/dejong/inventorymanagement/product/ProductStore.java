package nl.daniel.dejong.inventorymanagement.product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductStore {
    private final Map<ProductId, Product> products = new HashMap<>();

    public ProductStore() {
        products.put(new ProductId("Cola"), new Product("Cola", 10));
        products.put(new ProductId("Fanta"), new Product("Fanta", 15));
        products.put(new ProductId("Sprite"), new Product("Sprite",20));
    }

    public Optional<Product> getProduct(ProductId productId) {
        return Optional.ofNullable(products.get(productId));
    }
}
