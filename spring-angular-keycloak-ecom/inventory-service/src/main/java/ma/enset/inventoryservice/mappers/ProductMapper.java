package ma.enset.inventoryservice.mappers;

import ma.enset.inventoryservice.dtos.ProductDTO;
import ma.enset.inventoryservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDto);
}
