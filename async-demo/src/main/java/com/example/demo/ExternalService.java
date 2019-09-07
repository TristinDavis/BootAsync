package com.example.demo;

import java.util.HashMap;

public class ExternalService {

	public HashMap<String, String> callToExternalService() {
		
		try {
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "value");
			Thread.sleep(10000);
			
			return map;
				
		} catch(Exception e) {
			
			System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
			return null;
		}
	}
}
