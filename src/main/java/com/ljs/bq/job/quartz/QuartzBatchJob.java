package com.ljs.bq.job.quartz;


import com.ljs.bq.config.batch.BeanUtil;
import com.ljs.bq.config.quartz.QuartzService;
import lombok.SneakyThrows;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class QuartzBatchJob extends QuartzJob{

    private final Logger logger = LoggerFactory.getLogger(QuartzBatchJob.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private BeanUtil beanUtil;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        // 전달 받은 JobDataMap에서 Job이름을 꺼내오고 그 Job이름으로 Context에서 Bean을 가져온다.
        Job job = (Job) beanUtil.getBean((String) jobDataMap.get(QuartzService.JOB_NAME));

        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("curDate", new Date())
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }
}
