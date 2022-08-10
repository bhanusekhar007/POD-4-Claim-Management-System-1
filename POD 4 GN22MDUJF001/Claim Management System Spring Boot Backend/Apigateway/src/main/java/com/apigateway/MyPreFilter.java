package com.apigateway;

import org.slf4j.LoggerFactory;

import java.util.Set;

import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;



import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter {

	final Logger logger=LoggerFactory.getLogger(MyPreFilter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		logger.info("My first pre-filer executed");
		
		String requestPath=exchange.getRequest().getPath().toString();
		logger.info("request path="+requestPath);
		
		HttpHeaders headers=exchange.getRequest().getHeaders();
		Set<String> headerNames=headers.keySet();
		headerNames.forEach((headerName)->{
			String headerValue=headers.getFirst(headerName);
			logger.info(headerName+" "+headerValue);
		});
		return chain.filter(exchange);
		
	}

}
