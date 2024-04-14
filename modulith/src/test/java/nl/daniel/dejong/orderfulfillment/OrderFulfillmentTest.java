package nl.daniel.dejong.orderfulfillment;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.product.Product;
import nl.daniel.dejong.inventorymanagement.product.ProductRepository;
import nl.daniel.dejong.orderfulfillment.order.OrderCreated;
import nl.daniel.dejong.orderfulfillment.order.OrderLine;
import nl.daniel.dejong.orderfulfillment.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.List;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@RequiredArgsConstructor
public class OrderFulfillmentTest {
    private final OrderService orderService;
    private final ProductRepository productRepository;

    @Test
    void createOrder(Scenario scenario) {
        productRepository.save(new Product("Cola", 10));
        productRepository.save(new Product("Sprite", 10));

        scenario.stimulate(() -> orderService.createOrder(List.of(
                        new OrderLine.OrderLineDef("Cola", 10),
                        new OrderLine.OrderLineDef("Sprite", 10)
                )))
                .andWaitForEventOfType(OrderCreated.class)
                .toArrive();
    }
}
