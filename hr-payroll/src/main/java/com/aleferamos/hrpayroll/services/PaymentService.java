package com.aleferamos.hrpayroll.services;

import com.aleferamos.hrpayroll.entities.Payment;
import com.aleferamos.hrpayroll.entities.Worker;
import com.aleferamos.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workId, int days){

        Worker worker = workerFeignClient.findById(workId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
