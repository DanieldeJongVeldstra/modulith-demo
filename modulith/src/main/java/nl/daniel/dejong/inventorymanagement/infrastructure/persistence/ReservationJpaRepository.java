package nl.daniel.dejong.inventorymanagement.infrastructure.persistence;

import nl.daniel.dejong.inventorymanagement.application.ReservationRepository;
import nl.daniel.dejong.inventorymanagement.domain.reservation.Reservation;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.ReservationId;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
@Repository
public interface ReservationJpaRepository extends ReservationRepository, JpaRepository<Reservation, ReservationId> {
}
