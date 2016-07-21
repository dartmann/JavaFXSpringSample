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
@PropertySource("classpath:application-test.properties")
public class TestContext {
	
	/**
	 * Because Spring does not automatically instantiate a {@link PropertySourcesPlaceholderConfigurer},
	 * we need to explicitly define such a bean in our Java config.
	 * @return a {@link PropertySourcesPlaceholderConfigurer} instance.
	 */
	@Bean
	PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
