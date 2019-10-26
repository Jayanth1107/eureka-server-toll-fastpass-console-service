package com.jayanth;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FastPassController {
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/customerDetails", params= {"fastpassid"})
	public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {
		
		FastPassCustomer customer = null;
		try{
			customer = restTemplate.getForObject("http://"
				//+ "localhost:8086"
				+"toll-fast-pass-service-instance"
				+ "/fastPass?fastpassid="+fastpassid, FastPassCustomer.class);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Customer: "+customer.toString());
		m.addAttribute("customer",customer);
		
		return "console";
	}

}
