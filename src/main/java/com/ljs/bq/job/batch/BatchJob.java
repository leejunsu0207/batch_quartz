package com.ljs.bq.job.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchJob {

    private final Logger logger = LoggerFactory.getLogger(BatchJob.class);

    JobBuilderFactory jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    public BatchJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean(name = "createJob1")
    public Job createJob1(){

        return jobBuilderFactory.get("createJob1")
                .start(createJob1_step1())
                .build();

    }

    @Bean
    public Step createJob1_step1(){
        return stepBuilderFactory.get("createJob1_step1")
                .tasklet((contribution, chunkContext) -> {
                    logger.info(">>>>>>>>>>>>> createJob1_step1 start!");
                    return RepeatStatus.FINISHED;
                }).build();
    }



}
