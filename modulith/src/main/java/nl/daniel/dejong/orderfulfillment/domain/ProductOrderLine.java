package nl.daniel.dejong.orderfulfillment.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import nl.daniel.dejong.orderfulfillment.domain.valueobjects.ProductOrderLineId;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@Getter
public class ProductOrderLine {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final ProductOrderLineId id;
    private final String productId;
    private final int quantity;

    public ProductOrderLine(OrderLineDef orderLineDef) {
        this.id = ProductOrderLineId.random();
        this.productId = orderLineDef.productId();
        this.quantity = orderLineDef.quantity();
    }

    public record OrderLineDef (String productId, int quantity) {
    }
}
