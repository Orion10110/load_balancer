package com.orion10110.training.loadbalancer.components.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {
	public static String getBody(HttpServletRequest request) {
	      String body = "";
	      if (request.getMethod().equals("POST") )
	      {
	        StringBuilder sb = new StringBuilder();
	        BufferedReader bufferedReader = null;

	        try {
	          bufferedReader =  request.getReader();
	          char[] charBuffer = new char[128];
	          int bytesRead;
	          while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
	            sb.append(charBuffer, 0, bytesRead);
	          }
	        } catch (IOException ex) {
	        } finally {
	          if (bufferedReader != null) {
	            try {
	              bufferedReader.close();
	            } catch (IOException ex) {
	            }
	          }
	        }
	        body = sb.toString();
	      }
	      return body;
	    }
}
