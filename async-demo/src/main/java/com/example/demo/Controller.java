package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	MyService service;
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String sampleController() {

		service.doSomething();
		return "In the sample controller";
	}

}
