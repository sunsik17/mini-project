package com.sparta.miniproject.controller.product;

import com.sparta.miniproject.domain.product.dto.request.RegistrationProduct;
import com.sparta.miniproject.domain.product.service.ProductWriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

	private final ProductWriteService productWriteService;

	@PostMapping
	public ResponseEntity<ResponseProduct> registrationProduct(
		@RequestBody @Valid RegistrationProduct registrationProduct) {

		return ResponseEntity.ok()
			.body(ResponseProduct.fromDto(productWriteService.create(registrationProduct)));
	}
}
