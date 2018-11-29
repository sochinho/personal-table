package org.personal.table.config;

import org.personal.table.exception.MyFirstException;
import org.personal.table.exception.MySecondException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import javax.net.ssl.SSLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRetry
public class RetryTemplateConfiguration {

    @Bean
    @Qualifier("myRetryTemplate")
    public RetryTemplate myRetryTemplate(@Qualifier("myRetryPolicy") SimpleRetryPolicy myRetryPolicy) {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(1000L);
        retryTemplate.setRetryPolicy(myRetryPolicy);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        return retryTemplate;
    }

    @Bean
    public SimpleRetryPolicy myRetryPolicy() {
        Map<Class<? extends Throwable>, Boolean> retryableExceptions = new HashMap<>();

        retryableExceptions.put(MyFirstException.class, true);
        retryableExceptions.put(SSLException.class, true);

        return new SimpleRetryPolicy(5, retryableExceptions);
    }
}
