package nl.daniel.dejong.inventorymanagement.domain.product.events;

import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.event.annotation.DomainEvent;
import org.springframework.modulith.events.Externalized;

@DomainEvent
@Externalized("product::#{id()}")
public record ProductCreated(ProductId id, String name, int quantity) {
}
