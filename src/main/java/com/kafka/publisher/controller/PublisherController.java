package com.kafka.publisher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.publisher.binding.CustomerDetails;
import com.kafka.publisher.service.ProducerService;

@RestController
public class PublisherController {

	@Autowired
	private ProducerService producerService;
	
	@PostMapping("/addcustomers")
	public String addCustomers(@RequestBody List<CustomerDetails> customerDetails) {
		String msg = producerService.addCustomer(customerDetails);
		return msg;
	}
}
