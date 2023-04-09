package vegetable.salevegetable.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vegetable.salevegetable.api.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
    
}
