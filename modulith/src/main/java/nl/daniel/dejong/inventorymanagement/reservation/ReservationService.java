package nl.daniel.dejong.inventorymanagement.reservation;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.product.Product;
import nl.daniel.dejong.inventorymanagement.product.ProductId;
import nl.daniel.dejong.inventorymanagement.product.ProductStore;
import org.jmolecules.ddd.annotation.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ProductStore productStore;

    public Reservation reserveProduct(String reservationOwner, ProductId productId, int quantity) {
        var availableProduct = productStore.getProduct(productId);

        if (availableProduct.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        Product product = availableProduct.get();
        return new Reservation(reservationOwner, productId, quantity, new AvailableStock(productId, product.getQuantity()));
    }
}
