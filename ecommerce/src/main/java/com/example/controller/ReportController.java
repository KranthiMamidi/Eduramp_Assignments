package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.services.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/top-products")
	public List<Object[]> top3Products() {
		return reportService.getTop3Products();
	}

	@GetMapping("/no-orders")
	public List<Customer> customersWithNoOrders() {
		return reportService.getCustomersWithNoOrders();
	}

	@GetMapping("/revenue")
	public List<Object[]> productRevenue() {
		return reportService.getProductRevenue();
	}

	@GetMapping("/top-customer")
	public Object[] topCustomer() {
		return reportService.getTopCustomer();
	}
}
