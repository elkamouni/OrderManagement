package ordermanagement.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    private IOrderService service;

    @RequestMapping(value = "/Orders", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<OrdersDTO> getOrderDetails(@RequestParam("OrderId") String id) throws Exception {
        OrdersDTO order;
        try {
            order = service.getOrderDetails(id);
            return ResponseEntity.ok(order);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/Orders", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> PostOrder(@RequestBody OrdersDTO order){
        service.PostOrder(order);
        return ResponseEntity.ok("Order with order id "  + order.getId() + " Created Successfully");
    }

}
