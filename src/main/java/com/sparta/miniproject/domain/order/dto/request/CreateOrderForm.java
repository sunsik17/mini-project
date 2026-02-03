package com.sparta.miniproject.domain.order.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderForm(
	@NotNull
	Long productId,
	@Positive(message = "Quantity must be positive")
	Long quantity
) {
}
