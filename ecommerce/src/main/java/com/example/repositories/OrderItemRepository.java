package com.example.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.model.OrderItem;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	@Query("SELECT oi.product.name, SUM(oi.quantity * oi.product.price) FROM OrderItem oi GROUP BY oi.product.name")
	List<Object[]> getProductWiseRevenue();
}