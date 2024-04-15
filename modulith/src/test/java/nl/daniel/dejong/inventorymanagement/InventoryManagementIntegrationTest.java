package nl.daniel.dejong.inventorymanagement;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.reservation.events.ReservationCreated;
import nl.daniel.dejong.inventorymanagement.infrastructure.persistence.ProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest
@RequiredArgsConstructor
class InventoryManagementIntegrationTest {
    private final ReservationAPI reservationAPI;
    private final ProductJpaRepository productRepository;

    @Test
    void reserveProduct(Scenario scenario) {
        productRepository.save(new Product("Cola", 10));

        scenario.stimulate(() -> reservationAPI.reserveProduct("Order-1", "Cola", 10))
                .andWaitForEventOfType(ReservationCreated.class)
                .toArrive();
    }
}