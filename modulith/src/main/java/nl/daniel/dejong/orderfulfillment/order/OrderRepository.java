package nl.daniel.dejong.orderfulfillment.order;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, OrderId> {
}
