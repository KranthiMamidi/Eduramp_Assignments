package com.example.services;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repositories.CustomerRepository;
import com.example.repositories.OrderItemRepository;
import com.example.repositories.OrderRepository;
import com.example.repositories.ProductRepository;

@Service
public class ReportService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Autowired
	private OrderRepository orderRepo;

	public List<Object[]> getTop3Products() {
		return productRepo.findTopSellingProducts(PageRequest.of(0, 3));
	}

	public List<Customer> getCustomersWithNoOrders() {
		return customerRepo.findCustomersWithNoOrders();
	}

	public List<Object[]> getProductRevenue() {
		return orderItemRepo.getProductWiseRevenue();
	}

	public Object[] getTopCustomer() {
		return orderRepo.getCustomerWithHighestPurchase().get(0);
	}

}
