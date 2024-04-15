package nl.daniel.dejong.inventorymanagement.domain.reservation;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import nl.daniel.dejong.inventorymanagement.domain.reservation.events.ReservationCreated;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.AvailableStock;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.ReservationId;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

@AggregateRoot
@Getter
public class Reservation extends AbstractAggregateRoot<Reservation> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final ReservationId id;
    private final String reservationOwner;
    @AttributeOverride(name = "value", column = @Column(name = "productId"))
    private final ProductId productId;
    private final int quantity;

    public Reservation(String reservationOwner, ProductId productId, int quantity, AvailableStock availableStock) {
        this.id = ReservationId.random();
        this.reservationOwner = reservationOwner;
        this.productId = productId;
        this.quantity = quantity;

        checkAvailableStock(availableStock);
        registerEvent(new ReservationCreated(id, reservationOwner, productId, quantity));
    }

    private void checkAvailableStock(AvailableStock availableStock) {
        if (availableStock.quantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
    }
}
