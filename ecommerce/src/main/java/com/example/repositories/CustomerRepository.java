package com.example.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT c FROM Customer c WHERE c.id NOT IN (SELECT o.customer.id FROM Order o)")
	List<Customer> findCustomersWithNoOrders();
}