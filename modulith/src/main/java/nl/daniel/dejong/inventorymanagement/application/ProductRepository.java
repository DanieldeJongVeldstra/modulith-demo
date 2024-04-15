package nl.daniel.dejong.inventorymanagement.application;

import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.architecture.hexagonal.Port;

import java.util.Optional;

@Port
public interface ProductRepository {
    Optional<Product> findById(ProductId productId);
}
