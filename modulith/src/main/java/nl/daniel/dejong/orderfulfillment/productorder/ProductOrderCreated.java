package nl.daniel.dejong.orderfulfillment.productorder;

import org.jmolecules.event.annotation.DomainEvent;

import java.util.List;

@DomainEvent
public record ProductOrderCreated(ProductOrderId id, List<ProductOrderLine> productOrderLines) {
}
