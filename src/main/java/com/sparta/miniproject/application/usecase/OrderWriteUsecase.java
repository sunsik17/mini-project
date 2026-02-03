package com.sparta.miniproject.application.usecase;

import com.sparta.miniproject.domain.order.dto.request.CreateOrderForm;
import com.sparta.miniproject.domain.order.dto.response.OrderResponse;
import com.sparta.miniproject.domain.order.service.OrderWriteService;
import com.sparta.miniproject.domain.product.dto.ProductDto;
import com.sparta.miniproject.domain.product.service.ProductReadService;
import com.sparta.miniproject.domain.product.service.ProductWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderWriteUsecase {

	private final OrderWriteService orderWriteService;
	private final ProductWriteService productWriteService;
	private final ProductReadService productReadService;

	public OrderResponse execute(CreateOrderForm createOrderForm) {
		ProductDto productDto = productReadService.getOneProduct(createOrderForm.productId());
		productWriteService.decreaseStock(productDto, createOrderForm.quantity());
		return OrderResponse.fromDto(
			orderWriteService.createOrder(productDto, createOrderForm)
		);
	}
}
