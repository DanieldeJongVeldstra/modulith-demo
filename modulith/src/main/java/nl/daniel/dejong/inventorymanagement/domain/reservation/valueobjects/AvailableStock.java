package nl.daniel.dejong.inventorymanagement.domain.reservation.valueobjects;

import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;

public record AvailableStock(ProductId productId, int quantity) {
}
