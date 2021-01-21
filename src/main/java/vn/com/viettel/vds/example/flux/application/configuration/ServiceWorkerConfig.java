package vn.com.viettel.vds.example.flux.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class ServiceWorkerConfig {
    @Bean(value = "default-worker")
    public Scheduler defaultWorker() {
        return Schedulers.newBoundedElastic(
                20,
                Integer.MAX_VALUE,
                "default-worker");
    }
}
