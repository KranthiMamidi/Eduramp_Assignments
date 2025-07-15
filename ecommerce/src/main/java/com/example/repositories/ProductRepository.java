package com.example.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT oi.product.name, SUM(oi.quantity) AS totalQty "
			+ "FROM OrderItem oi GROUP BY oi.product.name ORDER BY totalQty DESC")
	List<Object[]> findTopSellingProducts(Pageable pageable);
}