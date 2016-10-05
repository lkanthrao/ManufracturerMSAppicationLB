package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;

import sun.print.resources.serviceui;

@RestController
public class ManufacturerMSLBController {

	@Autowired(required = true)
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getData() throws RestClientException, URISyntaxException {

		ServiceInstance instance = loadBalancerClient.choose("manufacturer-microservice"); // returns
																							// instance
																							// based
																							// on
																							// some
																							// algorithm

		System.out.println("------------------Kanth" + instance.getPort());

		RestTemplate restTemplate = new RestTemplate();

		Resources<Manufacturer> resource = null;
		

		ResponseEntity<String> entity = new ResponseEntity<String>(String.valueOf(instance.getPort()), HttpStatus.OK);
		try {
			resource = (Resources<Manufacturer>) restTemplate
					.getForObject(new URI(instance.getUri().toString().concat("/datarest")), (Object.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return entity.getBody();
	}
}
