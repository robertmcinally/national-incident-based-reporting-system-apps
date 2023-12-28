package org.jmresler.fbi.nibrs.config;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.dto.AgenciesDTO;
import org.jmresler.fbi.nibrs.lstnrs.ApplicationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class BatchConfiguration {

    @Bean
    public Job reportJob(
            final ApplicationListener applicationListener,
            final JobRepository repository,
            final Step reportStep
    ) {
        return new JobBuilder("report-job", repository)
                .listener(applicationListener)
                .start(reportStep).build();
    }

    @Bean
    public Step reportStep(
            final JobRepository repository,
            final PlatformTransactionManager transactionManager,
            final ApplicationListener applicationListener,
            final ItemReader<AgenciesDTO> agenciesDTOItemReader,
            final  ItemProcessor<AgenciesDTO, AgenciesDTO> agenciesDTOAgenciesDTOItemProcessor,
            final ItemWriter<AgenciesDTO> agenciesDTOItemWriter
            ) {
        return new StepBuilder("report-step", repository)
                .listener(applicationListener)
                .<AgenciesDTO, AgenciesDTO>chunk(100, transactionManager)
                .reader(agenciesDTOItemReader)
                .processor(agenciesDTOAgenciesDTOItemProcessor)
                .writer(agenciesDTOItemWriter)
                .build();
    }

    @Bean
    public ItemReader<AgenciesDTO> agenciesDTOItemReader() {
        return () -> null;
    }

    @Bean
    public ItemProcessor<AgenciesDTO, AgenciesDTO> agenciesDTOAgenciesDTOItemProcessor() {
        return item -> null;
    }

    @Bean
    public ItemWriter<AgenciesDTO> agenciesDTOItemWriter() {
        return chunk -> {

        };
    }

    @Bean
    public ApplicationListener applicationListener() {
        return new ApplicationListener();
    }
}
