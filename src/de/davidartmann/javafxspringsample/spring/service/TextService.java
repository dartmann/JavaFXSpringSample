package de.davidartmann.javafxspringsample.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.davidartmann.javafxspringsample.spring.db.model.Text;
import de.davidartmann.javafxspringsample.spring.db.repo.TextRepository;

@Service
public class TextService {

	@Autowired
	private TextRepository textRepository;
	
	public List<Text> getAllTexts() {
		return textRepository.findAll();
	}
	
	public Text saveText(String text) {
		Text model = new Text();
		model.setDescription(text);
		model.setTitle("dummyTitle");
		return textRepository.save(model);
	}
}
