package com.orion10110.training.loadbalancer.components.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.orion10110.training.loadbalancer.components.AwareUri;
import com.orion10110.training.loadbalancer.model.UriForLB;
import com.thoughtworks.xstream.XStream;

@Component
public class XmlUriImpl implements AwareUri {
	private XStream xstream;
	private File file;

	@PostConstruct
	private void init() throws IOException {

		xstream = new XStream();
		xstream.alias("uri", UriForLB.class);
		ClassLoader classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource("server-settings.xml").getFile());
		if (!file.exists()) {
			file.createNewFile();
			xstream.toXML(new ArrayList<Object>(), new FileOutputStream(file));
		}
	}

	public List<UriForLB> getAllUri() {
		return (List<UriForLB>) xstream.fromXML(file);
	}

}
