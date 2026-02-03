package com.sparta.miniproject.domain.product.dto;

import com.sparta.miniproject.domain.product.entity.Product;
import java.time.LocalDateTime;
import lombok.Builder;

public record ProductDto(
	Long id,
	String name,
	Long price,
	Long stock,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
	@Builder
	public ProductDto {}

	public static ProductDto from(Product product) {
		return ProductDto.builder()
			.id(product.getId())
			.name(product.getName())
			.price(product.getPrice())
			.stock(product.getStock())
			.createdAt(product.getCreatedAt())
			.updatedAt(product.getUpdatedAt())
			.build();
	}

	public Product toEntity() {
		return Product.builder()
			.id(this.id)
			.name(this.name)
			.price(this.price)
			.stock(this.stock)
			.build();
	}
}
