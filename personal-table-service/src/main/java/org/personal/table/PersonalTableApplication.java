package org.personal.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan("org.personal.table")
@EnableScheduling
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PersonalTableApplication {

    public static void main(String args[]) {
        SpringApplication.run(PersonalTableApplication.class);
    }

}
