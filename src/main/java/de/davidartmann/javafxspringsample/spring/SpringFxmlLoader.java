package de.davidartmann.javafxspringsample.spring;

import java.io.IOException;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.fxml.FXMLLoader;

public class SpringFxmlLoader {
	
	private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppContext.class);
	
	public <T> T load(URL url) {
		FXMLLoader fxmlLoader = new FXMLLoader(url);
		fxmlLoader.setControllerFactory(APPLICATION_CONTEXT::getBean);
		try {
			return fxmlLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Closes the {@link #APPLICATION_CONTEXT}.
	 */
	public void closeContext() {
		((ConfigurableApplicationContext) APPLICATION_CONTEXT).close();
	}
}
