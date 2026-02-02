package com.sparta.miniproject.domain.product.service;

import com.sparta.miniproject.domain.product.dto.ProductDto;
import com.sparta.miniproject.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductReadService {

	private final ProductRepository productRepository;

	public ProductDto getOneProduct(Long id) {
		return ProductDto.from(productRepository.findById(id).orElseThrow());
	}
}
