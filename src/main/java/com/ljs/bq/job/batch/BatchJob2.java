package com.ljs.bq.job.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchJob2 {

    private final Logger logger = LoggerFactory.getLogger(BatchJob2.class);

    JobBuilderFactory jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    public BatchJob2(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean(name = "createJob2")
    public Job createJob2(){

        return jobBuilderFactory.get("createJob2")
                .start(createJob2_step2())
                .build();

    }

    @Bean
    public Step createJob2_step2(){
        return stepBuilderFactory.get("createJob2_step2")
                .tasklet((contribution, chunkContext) -> {
                    logger.info(">>>>>>>>>>>>> createJob2_step2 start!");
                    return RepeatStatus.FINISHED;
                }).build();
    }


}
