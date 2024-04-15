package nl.daniel.dejong.orderfulfillment.infrastructure.persistence;

import nl.daniel.dejong.orderfulfillment.application.ProductOrderRepository;
import nl.daniel.dejong.orderfulfillment.domain.ProductOrder;
import nl.daniel.dejong.orderfulfillment.domain.valueobjects.ProductOrderId;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
@Repository
public interface ProductOrderJpaRepository extends ProductOrderRepository, JpaRepository<ProductOrder, ProductOrderId> {
}
