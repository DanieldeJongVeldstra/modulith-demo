package nl.daniel.dejong.inventorymanagement.domain.product.valueobjects;

import lombok.EqualsAndHashCode;
import nl.daniel.dejong.common.URN;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@EqualsAndHashCode(callSuper = true)
public class ProductId extends URN<String> {
    public final static String NAMESPACE = "product";
    public ProductId(String value) {
        super(value, NAMESPACE);
    }

    public ProductId() {
        super(null, NAMESPACE);
    }

    public String toString() {
        return super.toString();
    }
}
