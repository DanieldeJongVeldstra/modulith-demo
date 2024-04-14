package nl.daniel.dejong.inventorymanagement.reservation;

import nl.daniel.dejong.inventorymanagement.product.ProductId;

public record AvailableStock(ProductId productId, int quantity) {
}
