package com.orion10110.training.loadbalancer.components;

import com.orion10110.training.loadbalancer.model.UriForLB;

public interface RestServers {
	UriForLB getUri();
}
