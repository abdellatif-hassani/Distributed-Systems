package ma.enset.orderservice.mappers;

import ma.enset.orderservice.dtos.OrderDTO;
import ma.enset.orderservice.dtos.OrderItemDTO;
import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemDTO toOrderItemDTO(OrderItem orderItem);
    OrderItem toOrderItem(OrderItemDTO orderItemDTO);
}