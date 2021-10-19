package com.liu.code.gateway.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class QpsCounter implements ApplicationRunner {
    public static long count = 0;
    public static long MAX_COUNT = 10000;
    public static long TIME_SPAN = 5;
    private long preCount = 0;

    @Override
    public void run(ApplicationArguments args) {
        // 这样可以监测QPS
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(() -> {
            double qps;
            if (preCount >= MAX_COUNT)
                qps = count * 1.0 / TIME_SPAN;
            else qps = (count - preCount) * 1.0 / TIME_SPAN;
            System.out.println("rate: " + qps + " QPS");
            preCount = count;
            if (count >= MAX_COUNT)
                count = 0;
        }, 0, TIME_SPAN, TimeUnit.SECONDS);
    }
}
