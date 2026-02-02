package com.sparta.miniproject.domain.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record RegistrationProductForm(
	@NotBlank(message = "상품명은 필수 입력 항목입니다.")
	@Length(min = 1, max = 20, message = "상품명은 1자 이상 20자 이하로 입력해주세요.")
	String name,

	@Positive(message = "상품 가격은 양수여야 합니다.")
	Long price,

	@Positive(message = "상품 재고는 양수여야 합니다.")
	Long stock
) {

}
