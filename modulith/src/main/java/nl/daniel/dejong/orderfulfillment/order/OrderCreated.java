package nl.daniel.dejong.orderfulfillment.order;

import org.jmolecules.event.annotation.DomainEvent;

import java.util.List;

@DomainEvent
public record OrderCreated (OrderId id, List<OrderLine> orderLines) {
}
