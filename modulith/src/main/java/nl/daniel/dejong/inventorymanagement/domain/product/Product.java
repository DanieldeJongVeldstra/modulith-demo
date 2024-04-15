package nl.daniel.dejong.inventorymanagement.domain.product;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import nl.daniel.dejong.inventorymanagement.domain.product.events.ProductCreated;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

@AggregateRoot
@Getter
public class Product extends AbstractAggregateRoot<Product> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final ProductId id;
    private final String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.id = new ProductId(name);
        this.name = name;
        this.quantity = quantity;
        registerEvent(new ProductCreated(id, name, quantity));
    }
}
