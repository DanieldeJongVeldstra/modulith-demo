package nl.daniel.dejong.inventorymanagement.reservation;

import nl.daniel.dejong.inventorymanagement.product.ProductId;
import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record ReservationCreated(ReservationId id, String reservationOwner, ProductId productId, int quantity) {
}
