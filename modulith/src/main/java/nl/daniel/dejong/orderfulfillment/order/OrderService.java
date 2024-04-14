package nl.daniel.dejong.orderfulfillment.order;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.ReservationAPI;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ReservationAPI reservationAPI;

    public void createOrder(List<OrderLine.OrderLineDef> orderLines) {
        ProductOrder productOrder = new ProductOrder(orderLines);
        productOrder.getOrderLines().forEach(orderLine ->
                reservationAPI.reserveProduct(productOrder.getId().toString(), orderLine.getProductId(), orderLine.getQuantity()));

        orderRepository.save(productOrder);
    }
}
