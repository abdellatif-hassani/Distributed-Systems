package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityEx2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityEx2Application.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null, "Dell XPS 13", 1300, 10));
            productRepository.save(new Product(null, "HP Pavilion", 900, 10));
            productRepository.save(new Product(null, "Lenovo Thinkpad", 1200, 10));
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
