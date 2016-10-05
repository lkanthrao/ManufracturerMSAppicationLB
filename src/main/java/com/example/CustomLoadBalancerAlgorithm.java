package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class CustomLoadBalancerAlgorithm {
	
	@Autowired
	private IClientConfig ribbonClientConfig;
	
	@Bean
	@Autowired
	public IPing ribbonPing(IClientConfig clientConfig){
		return new PingUrl();
		
	}
	
	
	/*@Bean
	@Autowired
	public IRule ribbonAvailability(IClientConfig clientConfig){
		return new AvailabilityFilteringRule();
		
	}*/

}
