package ma.enset.inventoryservice.service;

import ma.enset.inventoryservice.dtos.ProductDTO;
import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.mappers.ProductMapper;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public IProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(productMapper.toProductDTO(product));
        }
        return productDTOS;
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDTO(savedProduct);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toProductDTO(updatedProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
