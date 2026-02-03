package com.sparta.miniproject.domain.order.service;

import com.sparta.miniproject.domain.order.dto.OrderDto;
import com.sparta.miniproject.domain.order.entity.Order;
import com.sparta.miniproject.domain.order.repository.OrderRepository;
import com.sparta.miniproject.util.PageResult;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderReadService {

	private final OrderRepository orderRepository;

	public PageResult<OrderDto> getAllOrders(Pageable pageable) {
		List<Order> orders = orderRepository.findAll(pageable).stream().toList();

		Long nextKey = orders.isEmpty() ? null :
			orders.stream()
				.mapToLong(Order::getId)
				.max().orElse(PageResult.NON_KEY);

		return new PageResult<>(
			orders.stream()
				.map(OrderDto::from)
				.collect(Collectors.toList()),
			hasNext(nextKey)
		);

	}

	private boolean hasNext(Long id) {
		if (id == null) {
			return false;
		}
		return orderRepository.existsByIdGreaterThan(id);
	}

}
