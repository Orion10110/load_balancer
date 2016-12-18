package com.orion10110.training.loadbalancer;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orion10110.training.loadbalancer.components.RestServers;
import com.orion10110.training.loadbalancer.components.util.HttpUtil;
import com.orion10110.training.loadbalancer.model.UriForLB;

@RestController
public class ProxyController {
	@Inject
	private RestServers restServers;
	private RestTemplate rest = new RestTemplate();
	

	@RequestMapping("/**")
	public ResponseEntity<String>  mirrorRest(
 @RequestHeader HttpHeaders headers,HttpMethod method, HttpServletRequest request,
	    HttpServletResponse response) throws URISyntaxException
	{
		UriForLB serverUri =restServers.getUri();
	    URI uri = new URI(serverUri.getScheme(), null, serverUri.getServer(), serverUri.getPort(), request.getRequestURI(), request.getQueryString(), null);
	    String body = HttpUtil.getBody(request);
	    HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
	    ResponseEntity<String> responseEntity = rest.exchange(uri, method, requestEntity, String.class);
	    
	    
	    return responseEntity;
	}
	

}
