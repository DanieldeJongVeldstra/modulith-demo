package nl.daniel.dejong.orderfulfillment.application;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.ReservationAPI;
import nl.daniel.dejong.orderfulfillment.domain.ProductOrder;
import nl.daniel.dejong.orderfulfillment.domain.ProductOrderLine;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ReservationAPI reservationAPI;

    public void createOrder(String requester, List<ProductOrderLine.OrderLineDef> orderLines) {
        ProductOrder productOrder = new ProductOrder(requester, orderLines);
        productOrder.getProductOrderLines().forEach(orderLine ->
                reservationAPI.reserveProduct(productOrder.getId().toString(), orderLine.getProductId(), orderLine.getQuantity()));

        productOrderRepository.save(productOrder);
    }
}
