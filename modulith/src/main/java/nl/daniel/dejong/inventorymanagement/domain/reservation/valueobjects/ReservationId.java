package nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects;

import nl.daniel.dejong.common.URN;

import java.util.UUID;

public class ReservationId extends URN<UUID> {
    public final static String NAMESPACE = "reservation";
    public ReservationId(UUID value) {
        super(value, NAMESPACE);
    }

    public ReservationId() {
        super(null, NAMESPACE);
    }

    public static ReservationId random() {
        return new ReservationId(UUID.randomUUID());
    }
}
