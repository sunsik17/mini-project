package com.sparta.miniproject.domain.product.dto.response;

import com.sparta.miniproject.domain.product.dto.ProductDto;
import lombok.Builder;

public record ResponseProduct(
	String name,
	Long price,
	Long stock
) {

	@Builder
	public ResponseProduct {
	}

	public static ResponseProduct fromDto(ProductDto productDto) {
		return ResponseProduct.builder()
			.name(productDto.name())
			.price(productDto.price())
			.stock(productDto.stock())
			.build();
	}
}
