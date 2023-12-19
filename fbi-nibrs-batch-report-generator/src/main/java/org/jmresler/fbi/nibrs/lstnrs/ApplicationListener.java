package org.jmresler.fbi.nibrs.lstnrs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;

@Slf4j
public class ApplicationListener implements JobExecutionListener, StepExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobExecutionListener.super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        StepExecutionListener.super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.debug("{} had rows skipped {}", stepExecution.getStepName(), stepExecution.getSkipCount());

        return StepExecutionListener.super.afterStep(stepExecution);
    }
}
