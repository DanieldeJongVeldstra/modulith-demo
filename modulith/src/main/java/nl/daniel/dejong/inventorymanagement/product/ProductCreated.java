package nl.daniel.dejong.inventorymanagement.product;

import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record ProductCreated(ProductId id, String name, int quantity) {
}
