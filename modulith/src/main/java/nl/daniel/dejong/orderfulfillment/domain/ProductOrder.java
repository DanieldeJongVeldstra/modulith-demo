package nl.daniel.dejong.orderfulfillment.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import nl.daniel.dejong.orderfulfillment.domain.events.ProductOrderCreated;
import nl.daniel.dejong.orderfulfillment.domain.valueobjects.ProductOrderId;
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
    private final String orderOwner;
    private final List<ProductOrderLine> productOrderLines = new ArrayList<>();

    public ProductOrder(String orderOwner, List<ProductOrderLine.OrderLineDef> orderLines) {
        this.id = ProductOrderId.random();
        this.orderOwner = orderOwner;
        orderLines.forEach(orderLineDef ->
                this.productOrderLines.add(new ProductOrderLine(orderLineDef)));

        registerEvent(new ProductOrderCreated(
                id,
                orderOwner,
                this.productOrderLines.stream().map(productOrderLine ->
                        new ProductOrderCreated.ProductOrderLine(
                                productOrderLine.getId().getValue(),
                                productOrderLine.getProductId(),
                                productOrderLine.getQuantity()
                        )
                ).toList()));
    }
}
