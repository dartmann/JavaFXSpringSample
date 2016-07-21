package de.davidartmann.javafxspringsample.main;
	
import java.io.File;

import org.springframework.beans.factory.BeanCreationException;

import de.davidartmann.javafxspringsample.spring.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static SpringFxmlLoader springFxmlLoader = null;
	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			try {
				springFxmlLoader = new SpringFxmlLoader();
			} catch (BeanCreationException e) {
				// TODO: show little message that application is already opened.
			}
			
			System.out.println(new File("/views/RootLayout.fxml").exists());
			
			AnchorPane root = springFxmlLoader.load(getClass().getResource("/views/RootLayout.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		if (springFxmlLoader != null) {
			springFxmlLoader.closeContext();
		}
	}
	
}
