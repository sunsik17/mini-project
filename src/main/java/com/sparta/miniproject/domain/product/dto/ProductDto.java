package com.sparta.miniproject.domain.product.dto;

import com.sparta.miniproject.domain.product.entity.Product;
import java.time.LocalDateTime;

public record ProductDto(
	String name,
	Long price,
	Long stock,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
	public static ProductDto from(Product product) {
		return new ProductDto(
			product.getName(),
			product.getPrice(),
			product.getStock(),
			product.getCreatedAt(),
			product.getUpdatedAt()
		);
	}
}
