package com.sparta.miniproject.domain.product.dto.request;

public record UpdateProductForm(
	String name,
	Long price,
	Long stock
) {
}
