package com.sparta.miniproject.domain.order.service;

import com.sparta.miniproject.domain.order.dto.OrderDto;
import com.sparta.miniproject.domain.order.entity.Order;
import com.sparta.miniproject.domain.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderReadService {

	private final OrderRepository orderRepository;

	public List<OrderDto> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
	}
}
