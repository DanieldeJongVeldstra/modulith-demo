package nl.daniel.dejong.orderfulfillment.order;

import com.fasterxml.jackson.annotation.JsonValue;
import nl.daniel.dejong.common.URN;

import java.util.UUID;

public class OrderLineId extends URN<UUID> {
    public final static String NAMESPACE = "order-line";
    public OrderLineId(UUID value) {
        super(value, NAMESPACE);
    }

    public OrderLineId() {
        super(null, NAMESPACE);
    }

    public static OrderLineId random() {
        return new OrderLineId(UUID.randomUUID());
    }

    @JsonValue
    public String toString() {
        return super.toString();
    }
}
