package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "ma.enset.customerservice",
        "ma.enset.security"
})
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "Jane", "Doe"));
            customerRepository.save(new Customer(null, "Jack", "Doe"));
            customerRepository.save(new Customer(null, "Jill", "Doe"));
            customerRepository.save(new Customer(null, "Jill", "Doe"));
            for (Customer customer : customerRepository.findAll()) {
                System.out.println(customer);
            }
        };
    }
}
