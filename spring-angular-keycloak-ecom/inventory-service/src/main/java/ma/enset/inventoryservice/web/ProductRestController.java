package ma.enset.inventoryservice.web;

import ma.enset.inventoryservice.dtos.ProductDTO;
import ma.enset.inventoryservice.repositories.ProductRepository;
import ma.enset.inventoryservice.service.IProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
    private final IProductService productService;
    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }
    // Endpoint for list of all products
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }
    //Endpoint for product by ID
    public ProductDTO getProductById(Long id) {
        return productService.findById(id);
    }
    //Endpoint for saving a new Product
    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }
    // Endpoint for updating a Product
    @PutMapping("/products")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }
    // Endpoint for deleting a Product by ID
    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProductById(@PathVariable Long id) {
        productService.delete(id);
    }
}
