package io.junq.examples.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "io.junq.examples.spring.web" })
@EnableWebMvc
public class WebConfiguration {

	public WebConfiguration() {
		super();
	}
	
}