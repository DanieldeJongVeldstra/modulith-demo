package nl.daniel.dejong.orderfulfillment;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.infrastructure.persistence.ProductJpaRepository;
import nl.daniel.dejong.orderfulfillment.application.ProductOrderService;
import nl.daniel.dejong.orderfulfillment.domain.ProductOrderLine;
import nl.daniel.dejong.orderfulfillment.domain.events.ProductOrderCreated;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.List;

@ApplicationModuleTest(extraIncludes = "inventorymanagement")
@RequiredArgsConstructor
public class OrderFulfillmentIntegrationTest {
    private final ProductOrderService productOrderService;
    private final ProductJpaRepository productRepository;

    @Test
    void createOrder(Scenario scenario) {
        productRepository.save(new Product("Cola", 10));
        productRepository.save(new Product("Sprite", 10));

        scenario.stimulate(() -> productOrderService.createOrder(
                        "Daniel",
                        List.of(
                                new ProductOrderLine.OrderLineDef("Cola", 10),
                                new ProductOrderLine.OrderLineDef("Sprite", 10)
                        )))
                .andWaitForEventOfType(ProductOrderCreated.class)
                .toArrive();
    }
}
