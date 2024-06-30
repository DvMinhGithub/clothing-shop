package com.example.demo.cronjob;

import com.example.demo.cronjob.task.ProductTask;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class DailyTaskScheduling {
    private final ProductTask productTask;

    public DailyTaskScheduling(Jedis jedis, ProductTask productTask) {
        this.productTask = productTask;
    }

    @Scheduled(cron = "0 0/15 * * * ?") // 15 minutes
    public void runDailyTask() {
        productTask.updateProductView();
    }

    @PostConstruct
    public void runOnStartUp() {
        productTask.updateProductView();
    }
}
