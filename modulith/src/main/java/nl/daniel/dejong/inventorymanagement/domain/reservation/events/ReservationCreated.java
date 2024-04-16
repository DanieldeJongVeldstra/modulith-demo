package nl.daniel.dejong.inventorymanagement.domain.reservation.events;

import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.ReservationId;
import org.jmolecules.event.annotation.DomainEvent;
import org.springframework.modulith.events.Externalized;

@DomainEvent
@Externalized("reservation::#{id()}")
public record ReservationCreated(ReservationId id, String reservationOwner, ProductId productId, int quantity) {
}
