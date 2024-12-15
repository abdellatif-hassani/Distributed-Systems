package ma.enset.customerservice.service;

import ma.enset.customerservice.dtos.CustomerDTO;
import ma.enset.customerservice.entities.Customer;

import java.util.List;

public interface ICustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO findCustomerById(Long id);
    List<CustomerDTO> findAllCustomers();
    void deleteCustomer(Long id);
}
