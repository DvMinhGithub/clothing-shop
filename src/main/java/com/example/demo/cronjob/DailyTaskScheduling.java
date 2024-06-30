package com.example.demo.cronjob;

import com.example.demo.cronjob.task.ProductTask;
import com.example.demo.cronjob.task.RevenueTask;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyTaskScheduling {
    private final ProductTask productTask;

    private final RevenueTask revenueTask;

    public DailyTaskScheduling(ProductTask productTask, RevenueTask revenueTask) {
        this.productTask = productTask;
        this.revenueTask = revenueTask;
    }

    @Scheduled(cron = "0 0/15 * * * ?")
    public void runTaskAfter15Minutes() {
        revenueTask.updateRevenue();
    }

    @Scheduled(cron = "0 0 * * * ?")
    public void runTaskStartOfDay(){
        revenueTask.createDayForRevenue();
    }

    @PostConstruct
    public void runOnStartUp() {
        revenueTask.updateRevenue();
        revenueTask.createDayForRevenue();
    }
}
