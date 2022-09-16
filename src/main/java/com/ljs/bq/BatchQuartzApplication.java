package com.ljs.bq;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class BatchQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchQuartzApplication.class, args);
    }

}
