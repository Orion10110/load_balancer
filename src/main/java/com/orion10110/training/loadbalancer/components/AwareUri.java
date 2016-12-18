package com.orion10110.training.loadbalancer.components;

import java.util.List;

import com.orion10110.training.loadbalancer.model.UriForLB;

public interface AwareUri {
	List<UriForLB> getAllUri();
}
