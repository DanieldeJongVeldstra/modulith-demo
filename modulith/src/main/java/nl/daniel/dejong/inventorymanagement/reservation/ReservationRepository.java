package nl.daniel.dejong.inventorymanagement.reservation;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
