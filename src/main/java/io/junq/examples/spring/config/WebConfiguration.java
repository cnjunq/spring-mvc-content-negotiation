package io.junq.examples.spring.config;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan({ "io.junq.examples.spring.web" })
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

	public WebConfiguration() {
		super();
	}
	
	public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
		// for Jackson pretty print
		final Iterator<HttpMessageConverter<?>> converterIterator = converters.stream().
				filter(c -> c instanceof AbstractJackson2HttpMessageConverter).iterator();
		
		while (converterIterator.hasNext()) {
			AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter)  converterIterator.next();
			converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		}
		
	}

	@Override
	public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
		// 方法一：后缀
//		configurer.favorPathExtension(true)
//			.favorParameter(false)
//			.ignoreAcceptHeader(true)
//			.useJaf(false)
//			.defaultContentType(MediaType.APPLICATION_JSON);
		
		// 方法二：查询参数
//		configurer
//			.favorPathExtension(false)
//			.favorParameter(true)
//			.parameterName("format")
//			.ignoreAcceptHeader(true)
//			.useJaf(false)
//			.defaultContentType(MediaType.APPLICATION_JSON)
//			.mediaType("xml", MediaType.APPLICATION_XML)
//			.mediaType("json", MediaType.APPLICATION_JSON);
		
		// 方式三：Accept字段
//	    configurer
//	      .favorPathExtension(false)
//	      .favorParameter(false)
//	      .ignoreAcceptHeader(false)
//	      .useJaf(false)
//	      .defaultContentType(MediaType.APPLICATION_JSON);
	}

}