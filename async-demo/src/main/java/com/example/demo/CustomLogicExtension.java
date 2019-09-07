package com.example.demo;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class CustomLogicExtension extends CustomLogic {

	@Autowired
	@Qualifier("customThreadExecutor")
	private TaskExecutor executor;

	@Override
	public String doFunction() {
		// TODO Auto-generated method stub

		CompletableFuture<HashMap<String, String>> future = CompletableFuture
				.supplyAsync(new Supplier<HashMap<String, String>>() {

					@Override
					public HashMap<String, String> get() {

						System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
						
						return new ExternalService().callToExternalService();
					}
				}, executor);

		future.thenAcceptAsync(new Consumer<HashMap<String, String>>() {

			@Override
			public void accept(HashMap<String, String> t) {
				// TODO Auto-generated method stub

			}
		}, executor);

		return "hello from custom logic";
	}
}
