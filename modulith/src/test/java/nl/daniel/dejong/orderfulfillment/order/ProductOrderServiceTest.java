package nl.daniel.dejong.orderfulfillment.order;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.ReservationAPI;
import nl.daniel.dejong.orderfulfillment.productorder.ProductOrderCreated;
import nl.daniel.dejong.orderfulfillment.productorder.ProductOrderLine;
import nl.daniel.dejong.orderfulfillment.productorder.ProductOrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.List;

@ApplicationModuleTest
@RequiredArgsConstructor
class ProductOrderServiceTest {
    @MockBean
    ReservationAPI reservationAPI;

    private final ProductOrderService sut;

    @Test
    void createOrder(Scenario scenario) {
        var orderLineDefs = List.of(
                new ProductOrderLine.OrderLineDef("Cola", 10),
                new ProductOrderLine.OrderLineDef("Sprite", 10)
        );

        Mockito.when(reservationAPI.reserveProduct(Mockito.anyString(), Mockito.contains("Cola"), Mockito.eq(10)))
                .thenReturn("Reservation 1");
        Mockito.when(reservationAPI.reserveProduct(Mockito.anyString(), Mockito.contains("Sprite"), Mockito.eq(10)))
                .thenReturn("Reservation 2");

        scenario.stimulate(() -> sut.createOrder(orderLineDefs))
                .andWaitForEventOfType(ProductOrderCreated.class)
                .toArrive();
    }
}