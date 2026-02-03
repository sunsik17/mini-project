package com.sparta.miniproject.application.controller.product;

import com.sparta.miniproject.domain.product.dto.request.RegistrationProductForm;
import com.sparta.miniproject.domain.product.dto.request.UpdateProductForm;
import com.sparta.miniproject.domain.product.dto.response.ResponseProduct;
import com.sparta.miniproject.domain.product.service.ProductReadService;
import com.sparta.miniproject.domain.product.service.ProductWriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

	private final ProductWriteService productWriteService;
	private final ProductReadService productReadService;

	@PostMapping
	public ResponseEntity<ResponseProduct> registrationProduct(
		@RequestBody @Valid RegistrationProductForm registrationProductForm) {

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(ResponseProduct.fromDto(productWriteService.create(registrationProductForm)));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseProduct> findProductById(
		@PathVariable Long id
	) {
		return ResponseEntity.ok()
			.body(ResponseProduct.fromDto(productReadService.getOneProduct(id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductById(
		@PathVariable Long id
	) {
		productWriteService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseProduct> updateProduct(
		@PathVariable Long id,
		@RequestBody @Valid UpdateProductForm updateProductForm
	) {
		return ResponseEntity.ok()
			.body(ResponseProduct.fromDto(productWriteService.update(updateProductForm, id)));

	}
}
