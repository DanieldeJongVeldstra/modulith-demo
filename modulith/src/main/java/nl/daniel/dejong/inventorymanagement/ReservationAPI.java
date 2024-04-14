package nl.daniel.dejong.inventorymanagement;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.product.ProductId;
import nl.daniel.dejong.inventorymanagement.reservation.ReservationService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationAPI {
    private final ReservationService reservationService;

    public String reserveProduct(String reservationOwner, String productId, int quantity) {
        var reservation = reservationService.reserveProduct(reservationOwner, new ProductId(productId), quantity);

        return reservation.getId().toString();
    }
}
