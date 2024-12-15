package ma.enset.inventoryservice.service;

import ma.enset.inventoryservice.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    void delete(Long id);
}
