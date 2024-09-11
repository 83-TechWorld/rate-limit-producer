package com.techworld83.ratelimitproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    void sendEmail(String email) {
     System.out.println();
     System.out.println("email sending by thread"+ Thread.currentThread().getName() +"_"+ email);
    }
}
