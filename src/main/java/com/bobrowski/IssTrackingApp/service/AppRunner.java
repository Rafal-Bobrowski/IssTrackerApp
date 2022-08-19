package com.bobrowski.IssTrackingApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {
    private final IssApiDataDownloaderInterface issApiDataDownloader;

    @Override
    public void run(ApplicationArguments args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(issApiDataDownloader, 0, 5, TimeUnit.SECONDS);
    }
}
