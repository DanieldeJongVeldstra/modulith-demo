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
public class Order extends AbstractAggregateRoot<Order> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final OrderId id;
    private final List<OrderLine> orderLines = new ArrayList<>();

    public Order(List<OrderLine.OrderLineDef> orderLines) {
        this.id = OrderId.random();
        orderLines.forEach(orderLineDef ->
                this.orderLines.add(new OrderLine(orderLineDef)));

        registerEvent(new OrderCreated(id, this.orderLines));
    }
}
