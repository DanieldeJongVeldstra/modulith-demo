package nl.daniel.dejong.inventorymanagement.application;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import nl.daniel.dejong.inventorymanagement.domain.reservation.Reservation;
import nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects.AvailableStock;
import org.jmolecules.ddd.annotation.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ProductRepository productRepository;

    public Reservation reserveProduct(String reservationOwner, ProductId productId, int quantity) {
        var availableProduct = productRepository.findById(productId);

        if (availableProduct.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        Product product = availableProduct.get();
        var reservation = new Reservation(reservationOwner, productId, quantity, new AvailableStock(productId, product.getQuantity()));

        return reservationRepository.save(reservation);
    }
}
