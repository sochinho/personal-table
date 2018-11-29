package org.personal.table.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryServiceImpl {

    @Autowired
    @Qualifier("myRetryTemplate")
    private RetryTemplate retryTemplate;

    public String simpleRetryableMethod() {
        log.info("simpleRetryableMethod() has been called");
        return "abcd";
    }

}
