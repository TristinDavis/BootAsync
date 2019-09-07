package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class Executors {

	@Bean("customThreadExecutor")
    public TaskExecutor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Custom-");
        executor.setKeepAliveSeconds(10000);
        executor.setCorePoolSize(10);
        executor.setKeepAliveSeconds(5);
        return executor;

    }
	
}
