package nl.daniel.dejong.orderfulfillment.productorder;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.ReservationAPI;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ReservationAPI reservationAPI;

    public void createOrder(List<ProductOrderLine.OrderLineDef> orderLines) {
        ProductOrder productOrder = new ProductOrder(orderLines);
        productOrder.getProductOrderLines().forEach(orderLine ->
                reservationAPI.reserveProduct(productOrder.getId().toString(), orderLine.getProductId(), orderLine.getQuantity()));

        productOrderRepository.save(productOrder);
    }
}
