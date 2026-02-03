package com.sparta.miniproject.domain.order.service;

import com.sparta.miniproject.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderReadService {

	private final OrderRepository orderRepository;

}
