package de.davidartmann.javafxspringsample.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("de.davidartmann.javafxspringsample")
@Import(PersistenceContext.class)
public class AppContext {
	
	@Bean
	PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Configuration
	@PropertySource("classpath:application.properties")
	static class ApplicationProperties {}
}
