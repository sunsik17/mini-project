package com.sparta.miniproject.domain.order.entity;

import com.sparta.miniproject.domain.BaseEntity;
import com.sparta.miniproject.domain.order.constants.OrderStatus;
import com.sparta.miniproject.domain.product.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	private Long quantity;

	@Column(nullable = false)
	private Long totalPrice;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus status;

	public void totalPriceCalculate(Long price, Long quantity) {
		Assert.isTrue(quantity > 0, "Quantity must be greater than 0");
		Assert.isTrue(price > 0, "Price must be greater than 0");
		this.totalPrice = price * quantity;
	}
}
