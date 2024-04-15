package nl.daniel.dejong.orderfulfillment.domain.valueobjects;

import lombok.EqualsAndHashCode;
import nl.daniel.dejong.common.URN;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.UUID;

@ValueObject
@EqualsAndHashCode(callSuper = true)
public class ProductOrderId extends URN<UUID> {
    public final static String NAMESPACE = "order";
    public ProductOrderId(UUID value) {
        super(value, NAMESPACE);
    }

    public ProductOrderId() {
        super(null, NAMESPACE);
    }

    public static ProductOrderId random() {
        return new ProductOrderId(UUID.randomUUID());
    }

    public String toString() {
        return super.toString();
    }
}
