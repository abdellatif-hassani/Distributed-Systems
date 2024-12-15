package ma.enset.orderservice.service;

import ma.enset.orderservice.dtos.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> findAll();
    OrderDTO findById(Long id);
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    void deleteById(Long id);
}
