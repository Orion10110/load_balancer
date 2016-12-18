package com.orion10110.training.loadbalancer.model;

public class UriForLB {
	private String scheme;
	private String server;
	private int port;

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getServer() {
		return server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setServer(String server) {
		this.server = server;
	}


}
