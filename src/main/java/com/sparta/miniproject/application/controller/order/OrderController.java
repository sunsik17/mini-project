package com.sparta.miniproject.application.controller.order;

import com.sparta.miniproject.application.usecase.OrderWriteUsecase;
import com.sparta.miniproject.domain.order.dto.OrderDto;
import com.sparta.miniproject.domain.order.dto.request.CreateOrderForm;
import com.sparta.miniproject.domain.order.dto.response.OrderResponse;
import com.sparta.miniproject.domain.order.service.OrderReadService;
import com.sparta.miniproject.util.PageResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

	private final OrderWriteUsecase orderWriteUsecase;
	private final OrderReadService orderReadService;

	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(
		@RequestBody @Valid CreateOrderForm createOrderForm
	) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(orderWriteUsecase.execute(createOrderForm));
	}

	@GetMapping
	public ResponseEntity<PageResult<OrderResponse>> getAllOrders(
		@RequestParam(value = "page", defaultValue = "0", required = false) int page,
		@RequestParam(value = "size", defaultValue = "10", required = false) int size,
		@RequestParam(value = "criteria", defaultValue = "createdAt", required = false) String criteria
	) {
		PageResult<OrderDto> allOrders = orderReadService.getAllOrders(
			PageRequest.of(page < 0 ? 0 : page, size, Sort.by(criteria)));
		return ResponseEntity.ok(new PageResult<>(
			allOrders.getBody().stream()
				.map(OrderResponse::fromDto).toList(),
			allOrders.isHasNext())
		);
	}
}
