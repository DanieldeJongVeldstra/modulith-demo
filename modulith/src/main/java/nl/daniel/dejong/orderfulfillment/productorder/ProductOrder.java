package nl.daniel.dejong.orderfulfillment.productorder;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
@Getter
public class ProductOrder extends AbstractAggregateRoot<ProductOrder> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "order_id"))
    private final ProductOrderId id;
    private final List<ProductOrderLine> productOrderLines = new ArrayList<>();

    public ProductOrder(List<ProductOrderLine.OrderLineDef> orderLines) {
        this.id = ProductOrderId.random();
        orderLines.forEach(orderLineDef ->
                this.productOrderLines.add(new ProductOrderLine(orderLineDef)));

        registerEvent(new ProductOrderCreated(id, this.productOrderLines));
    }
}
