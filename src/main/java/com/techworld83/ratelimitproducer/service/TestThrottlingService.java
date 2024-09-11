package com.techworld83.ratelimitproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TestThrottlingService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ThreadPoolTaskExecutor emailTaskExecutor;

    public void sendEmailsInBatches(List<String> emails) throws InterruptedException {
        int batchSize = 10; // Max 10 emails per second
        int totalEmails = emails.size();
        for (int i = 0; i < totalEmails; i += batchSize) {
            List<String> batch = emails.subList(i, Math.min(i + batchSize, totalEmails));
            System.out.println(System.currentTimeMillis());
            for (String email : batch) {
                emailTaskExecutor.execute(() -> emailService.sendEmail(email));
            }
            TimeUnit.SECONDS.sleep(30);
            System.out.println("After 30 seconds");
            System.out.println(System.currentTimeMillis());
        }
    }
}
