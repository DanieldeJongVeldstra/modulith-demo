package nl.daniel.dejong.orderfulfillment.productorder;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderId> {
}
