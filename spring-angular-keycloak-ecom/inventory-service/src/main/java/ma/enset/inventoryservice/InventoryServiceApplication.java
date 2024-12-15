package ma.enset.inventoryservice;

import ma.enset.inventoryservice.dtos.ProductDTO;
import ma.enset.inventoryservice.service.IProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "ma.enset.inventoryservice",
        "ma.enset.security"
})
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    // Saving a set of lines into DB by creating a Bean of CommandLineRunner
    @Bean
    CommandLineRunner commandLineRunner(IProductService productService) {
        return args -> {
            productService.save(new ProductDTO(null, "HP", 1200, 12));
            productService.save(new ProductDTO(null, "HP", 1200, 12));
            productService.save(new ProductDTO(null, "HP", 1200, 12));
            productService.findAll().forEach(System.out::println);
        };
    }

}
