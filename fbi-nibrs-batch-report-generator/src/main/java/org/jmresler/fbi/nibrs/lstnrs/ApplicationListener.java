package org.jmresler.fbi.nibrs.lstnrs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;

@Slf4j
public class ApplicationListener implements JobExecutionListener, StepExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobExecutionListener.super.beforeJob(jobExecution);
        log.debug("in beforeJob");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.debug("in afterJob");
        JobExecutionListener.super.afterJob(jobExecution);
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.debug("in beforeStep");
        StepExecutionListener.super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.debug("in afterStep");
        return StepExecutionListener.super.afterStep(stepExecution);
    }
}
