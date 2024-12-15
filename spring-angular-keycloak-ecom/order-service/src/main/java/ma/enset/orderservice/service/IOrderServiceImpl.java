package ma.enset.orderservice.service;

import ma.enset.orderservice.dtos.OrderDTO;
import ma.enset.orderservice.entities.Order;
import ma.enset.orderservice.feign.CustomerClient;
import ma.enset.orderservice.mappers.OrderItemMapper;
import ma.enset.orderservice.mappers.OrderMapper;
import ma.enset.orderservice.repositories.OrderItemRepository;
import ma.enset.orderservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IOrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final CustomerClient customerClient;

    public IOrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderMapper orderMapper, OrderItemMapper orderItemMapper, CustomerClient customerClient) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.customerClient = customerClient;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders =  orderRepository.findAll();
        for (Order order : orders) {
            order.setCustomer(customerClient.getCustomer(order.getCustomerId()));
        }
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orders) {
            orderDTOS.add(orderMapper.toOrderDto(order));
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        order.setCustomer(customerClient.getCustomer(order.getCustomerId()));
        return orderMapper.toOrderDto(order);
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toOrderDto(order);
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderDTO.getId()).orElse(null);
        order = orderMapper.toOrder(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toOrderDto(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
