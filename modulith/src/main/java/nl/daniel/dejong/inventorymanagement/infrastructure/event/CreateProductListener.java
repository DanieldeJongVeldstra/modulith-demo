package nl.daniel.dejong.inventorymanagement.infrastructure.event;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.application.ProductRepository;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.product.events.CreateProduct;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductListener {
    private final ProductRepository productRepository;

    @KafkaListener(topics = "create-product")
    public void onCreateProduct(CreateProduct createProduct) {
        var product = new Product(createProduct.name(), createProduct.quantity());
        productRepository.save(product);
    }
}
