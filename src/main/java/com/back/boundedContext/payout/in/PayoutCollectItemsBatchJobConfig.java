package com.back.boundedContext.payout.in;

import com.back.boundedContext.payout.app.PayoutFacede;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PayoutCollectItemsBatchJobConfig {
    private static final int CHUNK_SIZE = 10;

    private final PayoutFacede payoutFacede;

    public PayoutCollectItemsBatchJobConfig(PayoutFacede payoutFacede) {
        this.payoutFacede = payoutFacede;
    }

    @Bean
    public Job PayoutCollectItemsJob(JobRepository jobRepository, Step payoutCollectItemStop) {
        return new JobBuilder("payoutCollectItemsJob", jobRepository)
                .start(payoutCollectItemStop)
                .build();
    }

    @Bean
    public Step PayoutCollectItemsStep(JobRepository jobRepository) {
        return new StepBuilder("payoutCollectItemsStep", jobRepository)
                .tasklet(((contribution, chunkContext) -> {
                    int proceedCount = payoutFacede.collectPayoutItemsMore(CHUNK_SIZE).getData();

                    if (proceedCount == 0) {
                        return  RepeatStatus.FINISHED;
                    }

                    contribution.incrementWriteCount(proceedCount);

                    return RepeatStatus.CONTINUABLE;
                }))
                .build();
    }
}
