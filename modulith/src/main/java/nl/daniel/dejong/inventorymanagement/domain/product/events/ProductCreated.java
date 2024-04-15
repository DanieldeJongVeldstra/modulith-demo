package nl.daniel.dejong.inventorymanagement.domain.product.events;

import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record ProductCreated(ProductId id, String name, int quantity) {
}
