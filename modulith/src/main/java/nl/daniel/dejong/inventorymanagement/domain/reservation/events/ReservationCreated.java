package nl.daniel.dejong.inventorymanagement.domain.reservation.events;

import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.ReservationId;
import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record ReservationCreated(ReservationId id, String reservationOwner, ProductId productId, int quantity) {
}
