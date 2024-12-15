package ma.enset.orderservice;

import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.feign.CustomerClient;
import ma.enset.orderservice.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {
        "ma.enset.orderservice",
        "ma.enset.security"
})
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
//        return args -> {
//            orderRepository.save(new Order(null, 1L, "None", null, null));
//            orderRepository.save(new Order(null, 2L, "None", null, null));
//            orderRepository.save(new Order(null, 3L, "None", null, null));
//            orderRepository.save(new Order(null, 4L, "None", null, null));
//            orderRepository.findAll().forEach(System.out::println);
//            // Showing list of clients
//            //customerClient.getAllCustomers().forEach(System.out::println);
//        };
//    }
}
