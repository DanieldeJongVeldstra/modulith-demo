package nl.daniel.dejong.orderfulfillment.order;

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
    private final OrderId id;
    private final List<OrderLine> orderLines = new ArrayList<>();

    public ProductOrder(List<OrderLine.OrderLineDef> orderLines) {
        this.id = OrderId.random();
        orderLines.forEach(orderLineDef ->
                this.orderLines.add(new OrderLine(orderLineDef)));

        registerEvent(new OrderCreated(id, this.orderLines));
    }
}
