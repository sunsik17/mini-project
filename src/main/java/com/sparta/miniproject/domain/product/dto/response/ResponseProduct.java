package com.sparta.miniproject.domain.product.dto.response;

import com.sparta.miniproject.domain.product.dto.ProductDto;
import lombok.Builder;

@Builder
public record ResponseProduct(
	String name,
	Long price,
	Long stock
) {
	public static ResponseProduct fromDto(ProductDto productDto) {
		return ResponseProduct.builder()
			.name(productDto.name())
			.price(productDto.price())
			.stock(productDto.stock())
			.build();
	}
}
