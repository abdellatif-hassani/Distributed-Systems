package ma.enset.customerservice.web;

import ma.enset.customerservice.dtos.CustomerDTO;
import ma.enset.customerservice.service.ICustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {
    private final ICustomerService customerService;
    public CustomerRestController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    // Endpoint for list of customers
    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAllCustomers();
    }
    // Endpoint for customer by ID
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }
    // Endpoint for saving a new cutomer
    @PostMapping("/customers")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }
    // Endpoint for updating a customer
    @PutMapping("/customers")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerDTO);
    }
    //Endpoint for deleting a customer
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
