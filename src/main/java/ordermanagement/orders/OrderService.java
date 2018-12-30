package ordermanagement.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public OrdersDTO getOrderDetails(String id) throws Exception {
        OrdersDTO order = repository.getOrderDetails(id);
        if(order == null){
            throw new Exception("Order not found");
        }
        return order;
    }

    @Override
    public OrdersDTO PostOrder(OrdersDTO order) {

        return repository.PostOrder(order);
    }

}
