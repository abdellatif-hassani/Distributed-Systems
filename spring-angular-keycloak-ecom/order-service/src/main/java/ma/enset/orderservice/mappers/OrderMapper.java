package ma.enset.orderservice.mappers;
import ma.enset.orderservice.dtos.OrderDTO;
import ma.enset.orderservice.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDto(Order product);
    Order toOrder(OrderDTO productDto);
}
