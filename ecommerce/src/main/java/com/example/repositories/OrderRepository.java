package com.example.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query("SELECT o.customer.name, SUM(oi.quantity * oi.product.price) FROM Order o JOIN o.customer c JOIN OrderItem oi ON oi.order.id = o.id GROUP BY c.name ORDER BY SUM(oi.quantity * oi.product.price) DESC")
	List<Object[]> getCustomerWithHighestPurchase();
}