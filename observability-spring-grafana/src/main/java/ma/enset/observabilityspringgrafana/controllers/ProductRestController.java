package ma.enset.observabilityspringgrafana.controllers;

import lombok.AllArgsConstructor;
import ma.enset.observabilityspringgrafana.entities.Product;
import ma.enset.observabilityspringgrafana.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductRestController {
    private ProductRepository productRepository;

    @GetMapping({"/", ""})
    public List<Product> products() {
        return productRepository.findAll();
    }

}
