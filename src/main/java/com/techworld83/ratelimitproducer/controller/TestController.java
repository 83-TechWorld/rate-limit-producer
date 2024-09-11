package com.techworld83.ratelimitproducer.controller;

import com.techworld83.ratelimitproducer.MockData;
import com.techworld83.ratelimitproducer.service.TestThrottlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private TestThrottlingService testThrottlingService;

    @RequestMapping("/thread")
    public String testThread(){
        try {
            this.testThrottlingService.sendEmailsInBatches(MockData.mails);
            return "BatchProcessedSuccessfully";
        } catch (InterruptedException e) {
            return "Error while sending emails: " + e.getMessage();
        }
    }
}
