package vegetable.salevegetable.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vegetable.salevegetable.api.model.Order;
import vegetable.salevegetable.api.repository.OrderRepository;
import vegetable.salevegetable.api.service.OrderService;




@RestController
@RequestMapping("api/order")
public class OrderController implements OrderService{

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping
    @Override
    public List<Order> listOrder() {
        return orderRepository.findAll();
    }

    @GetMapping("{id}")
    @Override
    public Order getOrder(@PathVariable("id") Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
    @PostMapping
    @Override
    public Order addOrder(@RequestBody Order order) {
       return orderRepository.save(order);
       
    }
    // @PutMapping("{id}")
    // @Override
    // public Order updateOrder(@PathVariable("id") Integer id, @RequestBody Order order) {
    //     return orderRepository.findById(id).map(orderUpdate -> {
    //         orderUpdate.setName(order.getName());
    //         orderUpdate.setAddress(null);(vegetable.getStatus());
    //         return orderRepository.save(orderUpdate);
    //     }).orElse(null);
    // }

    // @Override
    // public boolean deleteOrder(Integer id) {
        
    // }
    
}
