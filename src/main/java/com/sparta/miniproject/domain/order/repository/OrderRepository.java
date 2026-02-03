package com.sparta.miniproject.domain.order.repository;

import com.sparta.miniproject.domain.order.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Override
	@EntityGraph(attributePaths = {"product"})
	Page<Order> findAll(Pageable pageable);

	boolean existsByIdGreaterThan(Long id);
}
