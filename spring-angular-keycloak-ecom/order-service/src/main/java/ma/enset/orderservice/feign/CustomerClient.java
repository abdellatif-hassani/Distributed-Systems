package ma.enset.orderservice.feign;

import ma.enset.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {
    // Retreving list of customers
    @GetMapping("/api/v1/customers")
    List<Customer> getAllCustomers();

    // Getting a customer by ID
    @GetMapping("/api/v1/customers/{id}")
    Customer getCustomer(@PathVariable("id") Long id);
}
