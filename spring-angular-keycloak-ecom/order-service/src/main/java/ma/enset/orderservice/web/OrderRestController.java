package ma.enset.orderservice.web;

import ma.enset.orderservice.dtos.OrderDTO;
import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.feign.CustomerClient;
import ma.enset.orderservice.model.Customer;
import ma.enset.orderservice.repositories.OrderRepository;
import ma.enset.orderservice.service.IOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {
    private final IOrderService orderService;
    private final CustomerClient customerClient;

    public OrderRestController(IOrderService orderService, CustomerClient customerClient) {
        this.orderService = orderService;
        this.customerClient = customerClient;
    }

    //Endpoint for getting all orders
    @GetMapping("/orders")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    //Endpoint for getting an order by ID
    @GetMapping("/orders/{id}")
    public OrderDTO findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    // Endpoint for saving a new order
    @PostMapping("/orders")
    public OrderDTO save(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }

    // Endpoint for updating an order
    @PutMapping("/orders")
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        return orderService.update(orderDTO);
    }

    // Endpoint for deleting an order
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    // Endpont for testing CustumerFeignClient
    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerClient.getAllCustomers();
    }
    // Endpont for testing CustumerFeignClient
    @GetMapping("/customers/{id}")
    public Customer findCustomerByID(@PathVariable Long id) {
        return customerClient.getCustomer(id);
    }
}
