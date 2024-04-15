package nl.daniel.dejong.orderfulfillment.application;

import nl.daniel.dejong.orderfulfillment.domain.ProductOrder;
import org.jmolecules.architecture.hexagonal.Port;

@Port
public interface ProductOrderRepository {
    ProductOrder save(ProductOrder productOrder);
}
