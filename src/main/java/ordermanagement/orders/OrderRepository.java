package ordermanagement.orders;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class OrderRepository {

    HashMap<String,OrdersDTO> orders = new HashMap<>();
    public OrdersDTO getOrderDetails(String id) {
        return orders.get(id);
    }

    public OrdersDTO PostOrder(OrdersDTO order) {
        orders.put(order.getId(),order);
        return order;

    }
}
