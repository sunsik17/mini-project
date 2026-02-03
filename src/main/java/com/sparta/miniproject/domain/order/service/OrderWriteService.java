package com.sparta.miniproject.domain.order.service;

import com.sparta.miniproject.domain.order.constants.OrderStatus;
import com.sparta.miniproject.domain.order.dto.OrderDto;
import com.sparta.miniproject.domain.order.dto.request.CreateOrderForm;
import com.sparta.miniproject.domain.order.entity.Order;
import com.sparta.miniproject.domain.order.repository.OrderRepository;
import com.sparta.miniproject.domain.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderWriteService {

	private final OrderRepository orderRepository;

	public OrderDto createOrder(ProductDto productDto, CreateOrderForm createOrderForm) {
		Order order = Order.builder()
			.product(productDto.toEntity())
			.quantity(createOrderForm.quantity())
			.status(OrderStatus.CREATED)
			.build();
		order.totalPriceCalculate(productDto.price(), createOrderForm.quantity());

		return OrderDto.from(orderRepository.save(order));
	}
}
