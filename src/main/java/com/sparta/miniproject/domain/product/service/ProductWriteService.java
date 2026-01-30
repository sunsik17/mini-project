package com.sparta.miniproject.domain.product.service;

import com.sparta.miniproject.domain.product.dto.ProductDto;
import com.sparta.miniproject.domain.product.dto.request.RegistrationProduct;
import com.sparta.miniproject.domain.product.entity.Product;
import com.sparta.miniproject.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductWriteService {

	private final ProductRepository productRepository;

	public ProductDto create(RegistrationProduct registrationProduct) {
		return ProductDto.from(productRepository.save(Product.builder()
				.name(registrationProduct.name())
				.price(registrationProduct.price())
				.stock(registrationProduct.stock())
				.build()));
	}
}
