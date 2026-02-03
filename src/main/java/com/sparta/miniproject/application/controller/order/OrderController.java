package com.sparta.miniproject.application.controller.order;

import com.sparta.miniproject.application.usecase.OrderWriteUsecase;
import com.sparta.miniproject.domain.order.dto.request.CreateOrderForm;
import com.sparta.miniproject.domain.order.dto.response.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

	private final OrderWriteUsecase orderWriteUsecase;

	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(
		@RequestBody @Valid CreateOrderForm createOrderForm
	) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(orderWriteUsecase.execute(createOrderForm));
	}
}
