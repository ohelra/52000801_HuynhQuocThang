package vegetable.salevegetable.api.service;

import java.util.List;

import vegetable.salevegetable.api.model.Order;




public interface OrderService{
    public List<Order> listOrder();
    public Order   getOrder(Integer id);
    public Order addOrder(Order order);
   
    
}
