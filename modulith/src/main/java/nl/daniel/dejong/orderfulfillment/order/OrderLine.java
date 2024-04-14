package nl.daniel.dejong.orderfulfillment.order;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@Getter
public class OrderLine {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final OrderLineId id;
    private final String productId;
    private final int quantity;

    public OrderLine(OrderLineDef orderLineDef) {
        this.id = OrderLineId.random();
        this.productId = orderLineDef.productId();
        this.quantity = orderLineDef.quantity();
    }

    public record OrderLineDef (String productId, int quantity) {
    }
}
