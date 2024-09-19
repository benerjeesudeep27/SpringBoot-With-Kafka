package com.kafka.publisher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.kafka.publisher.binding.CustomerDetails;
import com.kafka.publisher.constants.AppConstants;

@Service
public class ProducerService {
	@Autowired
	private KafkaTemplate<String, List<CustomerDetails>> kafkaTemplate;
	
	public String addCustomer(List<CustomerDetails> customer) {
		kafkaTemplate.send(AppConstants.TOPIC, customer);
		return "Msg has been sent to the subscriber";
	}
}
