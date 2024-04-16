package nl.daniel.dejong.orderfulfillment.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonValue;
import nl.daniel.dejong.common.URN;

import java.util.UUID;

public class ProductOrderLineId extends URN<UUID> {
    public final static String NAMESPACE = "order-line";
    public ProductOrderLineId(UUID value) {
        super(value, NAMESPACE);
    }

    public ProductOrderLineId() {
        super(null, NAMESPACE);
    }

    public static ProductOrderLineId random() {
        return new ProductOrderLineId(UUID.randomUUID());
    }

    @JsonValue
    public String toString() {
        return super.toString();
    }
}
