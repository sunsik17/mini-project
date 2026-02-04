package com.sparta.miniproject.domain.order.dto;

import com.sparta.miniproject.domain.order.entity.Order;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record OrderDto(
	Long id,
	Long productId,
	String productName,
	Long quantity,
	Long totalPrice,
	String status,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
	public static OrderDto from(Order order) {
		return OrderDto.builder()
			.id(order.getId())
			.productId(order.getProduct().getId())
			.productName(order.getProduct().getName())
			.quantity(order.getQuantity())
			.totalPrice(order.getTotalPrice())
			.status(String.valueOf(order.getStatus()))
			.createdAt(order.getCreatedAt())
			.updatedAt(order.getUpdatedAt())
			.build();
	}
}
