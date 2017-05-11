package io.junq.examples.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "io.junq.examples.spring.service" })
public class ServiceConfiguration {

    public ServiceConfiguration() {
        super();
    }
	
}