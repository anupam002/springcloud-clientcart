package com.springcloud.cartClient.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.springcloud.cartClient.services.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Override
	public String getCart() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo =  eurekaClient.getNextServerFromEureka("order-service", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET,null, String.class);
//		JsonParser jsonParser = new JsonParser();
//		JsonObject jsonResponse = (JsonObject) jsonParser.parse(response.getBody());
		return response.getBody();
	}

}
