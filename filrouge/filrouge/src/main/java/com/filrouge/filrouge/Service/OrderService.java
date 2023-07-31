package com.filrouge.filrouge.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filrouge.filrouge.Model.Order;
import com.filrouge.filrouge.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Boolean modifyOrder(Order order, Integer id) {
        Optional<Order> orderToModify = orderRepository.findById(id);
        if (orderToModify.isPresent()) {
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    public boolean deleteOrderById(Integer id) {
        Optional<Order> orderToDelete = orderRepository.findById(id);
        if (orderToDelete.isPresent()) {
            orderRepository.deleteById(id);
            return true;

        }
        return false;

    }
}
