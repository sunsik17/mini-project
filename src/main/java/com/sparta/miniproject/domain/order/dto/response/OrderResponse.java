package com.sparta.miniproject.domain.order.dto.response;

import com.sparta.miniproject.domain.order.dto.OrderDto;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record OrderResponse(
	Long product_id,
	String productName,
	Long quantity,
	Long totalPrice,
	String status,
	LocalDateTime createdAt
) {

	public static OrderResponse fromDto(OrderDto orderDto) {
		return OrderResponse.builder()
				.product_id(orderDto.productId())
				.productName(orderDto.productName())
				.quantity(orderDto.quantity())
				.totalPrice(orderDto.totalPrice())
				.status(orderDto.status())
				.createdAt(orderDto.createdAt())
				.build();
	}
}
