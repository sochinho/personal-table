import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.personal.table.PersonalTableApplication;
import org.personal.table.exception.MyFirstException;
import org.personal.table.exception.MySecondException;
import org.personal.table.service.RetryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.net.ssl.SSLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PersonalTableApplication.class)
@Slf4j
public class RetryServiceImplTest {

    @Autowired
    @Qualifier("myRetryTemplate")
    private RetryTemplate retryTemplate;

    @Mock
    private RetryServiceImpl retryService;

    @Test
    public void testRetries() {

        when(retryService.simpleRetryableMethod()).thenThrow(MyFirstException.class);

        try {
            String result = retryTemplate.execute((RetryCallback<String, RuntimeException>) context -> {
                log.info("retryTemplate.execute with count: " + context.getRetryCount());
                return retryService.simpleRetryableMethod();
                // business logic here
            }, retryContext -> {
                log.warn("Recovering");
                return null;
            });
        } catch (RuntimeException ignored) {
            log.warn("Runtime exception");
        }

        Mockito.verify(retryService, times(5)).simpleRetryableMethod();
    }

    @Test
    public void testFailedRetry() {

        when(retryService.simpleRetryableMethod()).thenThrow(SSLException.class);

        try {
            String result = retryTemplate.execute((RetryCallback<String, RuntimeException>) context -> {
                log.info("retryTemplate.execute with count: " + context.getRetryCount());
                return retryService.simpleRetryableMethod();
                // business logic here
            }, retryContext -> {
                log.warn("Recovering");
                return null;
            });
        } catch (RuntimeException ignored) {
            log.warn("Runtime exception");
        }

        Mockito.verify(retryService, times(5)).simpleRetryableMethod();
    }

}
