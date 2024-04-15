package nl.daniel.dejong.inventorymanagement.infrastructure.persistence;

import nl.daniel.dejong.inventorymanagement.application.ProductRepository;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
@Repository
public interface ProductJpaRepository extends ProductRepository, JpaRepository<Product, ProductId> {
}
