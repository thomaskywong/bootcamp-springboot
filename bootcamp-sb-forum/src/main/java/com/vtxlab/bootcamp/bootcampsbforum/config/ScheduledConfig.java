package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledConfig {


  // Run every 5s 
  // @Scheduled(fixedRate = 2000)
  public void fixedRateTask() throws Exception {
    System.out.println("Starts fixedRate." + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("Ends fixedRate.");

  }

  // Run every 5s after completion of the last task
  // @Scheduled(fixedDelay = 2000)
  public void fixedDelayTask() throws Exception {
    System.out.println("Starts fixedDelay." + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("Ends fixedDelay.");
  }

  // Cron Expression - fixed delay every 5 second
  // @Scheduled(cron = "*/5 * * * * *")
  // Cron
  // @Async - not single thread
  // @Scheduled(cron = "*/5 * * * * ?")
  // @Async
  public void cornExpression1() throws InterruptedException {
    System.out.println("Starts cron1." + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("Ends cron1."  + System.currentTimeMillis());
  }

  // @Async - not single thread
  // @Scheduled(cron = "*/10 * * * * ?")
  // @Async
  public void cornExpression2() throws InterruptedException {
    System.out.println("Starts cron2." + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("Ends cron2."  + System.currentTimeMillis());
  }

}
