//DEMO: Uncommment for choreography
//package nl.daniel.dejong.inventorymanagement.reservation;
//
//import lombok.RequiredArgsConstructor;
//import nl.daniel.dejong.inventorymanagement.product.ProductId;
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
