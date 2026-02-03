package com.sparta.miniproject.domain.product.service;

import com.sparta.miniproject.domain.product.dto.ProductDto;
import com.sparta.miniproject.domain.product.dto.request.RegistrationProductForm;
import com.sparta.miniproject.domain.product.dto.request.UpdateProductForm;
import com.sparta.miniproject.domain.product.entity.Product;
import com.sparta.miniproject.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductWriteService {

	private final ProductRepository productRepository;

	public ProductDto create(RegistrationProductForm registrationProductForm) {
		return ProductDto.from(productRepository.save(Product.builder()
			.name(registrationProductForm.name())
			.price(registrationProductForm.price())
			.stock(registrationProductForm.stock())
			.build()));
	}

	public ProductDto update(UpdateProductForm updateProductForm, Long id) {
		Product product = productRepository.findById(id).orElseThrow(
			() -> new RuntimeException("Product not found")
		);
		product.modifyProduct(
			updateProductForm.name(),
			updateProductForm.price(),
			updateProductForm.stock()
		);
		return ProductDto.from(productRepository.save(product));
	}

	public void deleteProduct(Long id) {
		productRepository.findById(id).orElseThrow(
			//TODO customize exception
			() -> new RuntimeException("Product not found")
		);
		productRepository.deleteById(id);
	}

	public void decreaseStock(ProductDto productDto) {
		Product product = productDto.toEntity();
		product.decreaseStock();
		productRepository.save(product);
	}
}
