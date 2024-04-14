package nl.daniel.dejong.orderfulfillment.order;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import nl.daniel.dejong.common.URN;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.UUID;

@ValueObject
@EqualsAndHashCode(callSuper = true)
public class OrderId extends URN<UUID> {
    public final static String NAMESPACE = "order";
    public OrderId(UUID value) {
        super(value, NAMESPACE);
    }

    public OrderId() {
        super(null, NAMESPACE);
    }

    public static OrderId random() {
        return new OrderId(UUID.randomUUID());
    }

    @JsonValue
    public String toString() {
        return super.toString();
    }
}
