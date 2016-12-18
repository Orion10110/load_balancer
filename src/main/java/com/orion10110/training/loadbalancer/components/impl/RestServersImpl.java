package com.orion10110.training.loadbalancer.components.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.orion10110.training.loadbalancer.components.AwareUri;
import com.orion10110.training.loadbalancer.components.RestServers;
import com.orion10110.training.loadbalancer.model.UriForLB;

@Component
public class RestServersImpl implements RestServers{
	@Inject
	private AwareUri awareUri;
	
	private List<UriForLB> listUri;
	
	private int step=0;
	
	
	@PostConstruct
	private void init() {
		listUri=awareUri.getAllUri();
	}
	
	
	public UriForLB getUri(){
		step++;
		if(step>=countRestServers()){
			step=0;
			return listUri.get(step);
		}
		
		return listUri.get(step);
		
	}
	
	private int countRestServers(){
		return listUri.size();
	}
	
	
}
