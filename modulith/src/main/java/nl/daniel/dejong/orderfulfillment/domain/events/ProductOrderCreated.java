package nl.daniel.dejong.orderfulfillment.domain.events;

import nl.daniel.dejong.orderfulfillment.domain.valueobjects.ProductOrderId;
import org.jmolecules.event.annotation.DomainEvent;

import java.util.List;
import java.util.UUID;

@DomainEvent
public record ProductOrderCreated(ProductOrderId id, String orderOwner, List<ProductOrderLine> productOrderLines) {

    public record ProductOrderLine(UUID id, String productId, int quantity) {
    }
}
