package com.sparta.miniproject.domain.product.entity;

import com.sparta.miniproject.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long price;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Long stock;

	public void modifyProduct(String name, Long price, Long stock) {
		validationCheck(price, stock);
		this.name = name != null && !name.isBlank() ? name : this.name;
		this.price = price != null ? price : this.price;
		this.stock = stock != null ? stock : this.stock;
	}

	private void validationCheck(Long price, Long stock) {
		if (price != null && price < 0) {
			//TODO customize exception
			throw new RuntimeException("Price must be greater than 0");
		}
		if (stock != null && stock < 0) {
			//TODO customize exception
			throw new RuntimeException("Stock must be greater than 0");
		}
	}

	public void decreaseStock(Long quantity) {
		Assert.isTrue(stock - quantity >= 0, "Stock is not enough");
		this.stock -= quantity;
	}
}

