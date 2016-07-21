package de.davidartmann.javafxspringsample.view.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.davidartmann.javafxspringsample.spring.service.TextService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

@Controller
public class RootController {
	
	@Autowired
	private TextService textService;
	
	@FXML
	private GridPane gridPane;
	@FXML
	private Label label;
	@FXML
	private Button button;
	
	@FXML
	public void initialize() {
		label.setText(""+textService.getAllTexts().size());
	}
	
	@FXML
	public void onAction(Event event) {
		if (event.getSource() == button) {
			textService.saveText("new text "+new Date().getTime());
			label.setText(""+textService.getAllTexts().size());
		} else {
			System.out.println("unknown event!");
		}
	}
	
}
