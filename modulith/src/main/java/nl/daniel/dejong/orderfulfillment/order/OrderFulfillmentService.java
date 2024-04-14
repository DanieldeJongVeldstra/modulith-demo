package nl.daniel.dejong.orderfulfillment.order;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.ReservationAPI;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderFulfillmentService {
    private final ReservationAPI reservationAPI;

    public void createOrder(List<OrderLine.OrderLineDef> orderLines) {
        Order order = new Order(orderLines);

        order.getOrderLines().forEach(orderLine ->
                reservationAPI.reserveProduct(order.getId().toString(), orderLine.getProductId(), orderLine.getQuantity()));
    }
}
