package com.sparta.miniproject.controller.product;

import com.sparta.miniproject.domain.product.dto.request.RegistrationProduct;
import com.sparta.miniproject.domain.product.dto.response.ResponseProduct;
import com.sparta.miniproject.domain.product.service.ProductReadService;
import com.sparta.miniproject.domain.product.service.ProductWriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		@RequestBody @Valid RegistrationProduct registrationProduct) {

		return ResponseEntity.ok()
			.body(ResponseProduct.fromDto(productWriteService.create(registrationProduct)));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseProduct> findProductById(
		@PathVariable Long id
	) {
		return ResponseEntity.ok()
			.body(ResponseProduct.fromDto(productReadService.getOneProduct(id)));
	}
}
