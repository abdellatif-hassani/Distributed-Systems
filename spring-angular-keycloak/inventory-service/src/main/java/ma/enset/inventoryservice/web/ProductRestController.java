package ma.enset.inventoryservice.web;

import ma.enset.inventoryservice.entities.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.enset.inventoryservice.repositories.ProductRepository;

import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductRestController {
    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping({"", "/"})
    public List<Product> products(){
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        return products;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        Product product = productRepository.findById(id).orElse(null);
        System.out.println(product);
        return product;
    }

    @GetMapping("/auth")
    public Authentication auth(Authentication authentication){
        return authentication;
    }
}
