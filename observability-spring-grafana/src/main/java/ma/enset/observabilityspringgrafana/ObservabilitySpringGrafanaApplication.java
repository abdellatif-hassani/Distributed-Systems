package ma.enset.observabilityspringgrafana;

import ma.enset.observabilityspringgrafana.entities.Product;
import ma.enset.observabilityspringgrafana.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilitySpringGrafanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilitySpringGrafanaApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Dell XPS 15")
                            .price(1500)
                            .build());
            productRepository.save(Product.builder()
                            .name("MacBook Pro")
                            .price(2000)
                            .build());
            productRepository.save(Product.builder()
                            .name("HP Pavilion")
                            .price(1000)
                            .build());
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
