package nl.daniel.dejong.inventorymanagement.application;

import nl.daniel.dejong.inventorymanagement.domain.reservation.Reservation;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.ReservationId;
import org.jmolecules.architecture.hexagonal.Port;

import java.util.Optional;

@Port
public interface ReservationRepository {
    Optional<Reservation> findById(ReservationId reservationId);

    Reservation save(Reservation reservation);
}
