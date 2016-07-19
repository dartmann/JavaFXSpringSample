package de.davidartmann.javafxspringsample.spring.db.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import de.davidartmann.javafxspringsample.spring.db.model.Text;

public interface TextRepository extends Repository<Text, Long> {
	
	void delete(Text text);
	
	List<Text> findAll();

	Text findOne(Long id);
	
	Text save(Text text);
}
