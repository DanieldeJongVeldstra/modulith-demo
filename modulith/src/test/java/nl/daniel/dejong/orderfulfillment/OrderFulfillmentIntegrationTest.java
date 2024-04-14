package nl.daniel.dejong.orderfulfillment;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.product.Product;
import nl.daniel.dejong.inventorymanagement.product.ProductRepository;
import nl.daniel.dejong.orderfulfillment.productorder.ProductOrderCreated;
import nl.daniel.dejong.orderfulfillment.productorder.ProductOrderLine;
import nl.daniel.dejong.orderfulfillment.productorder.ProductOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.List;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@RequiredArgsConstructor
public class OrderFulfillmentIntegrationTest {
    private final ProductOrderService productOrderService;
    private final ProductRepository productRepository;

    @Test
    void createOrder(Scenario scenario) {
        productRepository.save(new Product("Cola", 10));
        productRepository.save(new Product("Sprite", 10));

        scenario.stimulate(() -> productOrderService.createOrder(List.of(
                        new ProductOrderLine.OrderLineDef("Cola", 10),
                        new ProductOrderLine.OrderLineDef("Sprite", 10)
                )))
                .andWaitForEventOfType(ProductOrderCreated.class)
                .toArrive();
    }
}
