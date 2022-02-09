package dev.oak3.java.demo.springbatchdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SimpleJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job testJob() {
        return this.jobBuilderFactory.get("testJob")
                .start(testStep1())
                .build();
    }

    public Step testStep1() {
        return stepBuilderFactory.get("testStep1")
                .tasklet(((contribution, chunkContext) -> null))
                .build();
    }
}
