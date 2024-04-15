//DEMO: Uncommment for choreography
//package nl.daniel.dejong.inventorymanagement.infrastructure.event;
//
//import lombok.RequiredArgsConstructor;
//import nl.daniel.dejong.inventorymanagement.application.ReservationService;
//import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
//import nl.daniel.dejong.orderfulfillment.domain.events.ProductOrderCreated;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class ProductOrderListener {
//    private final ReservationService reservationService;
//
//    public void onProductOrderCreated(ProductOrderCreated event) {
//        event.productOrderLines().forEach(productOrderLine -> {
//            reservationService.reserveProduct(event.orderOwner(), new ProductId(productOrderLine.productId()), productOrderLine.quantity());
//        });
//    }
//}
