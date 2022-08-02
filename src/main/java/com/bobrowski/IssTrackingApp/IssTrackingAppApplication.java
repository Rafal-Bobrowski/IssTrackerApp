package com.bobrowski.IssTrackingApp;

import com.bobrowski.IssTrackingApp.biz.service.IssApiDataDownloader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class IssTrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssTrackingAppApplication.class, args);
	}

}
