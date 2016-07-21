package de.davidartmann.javafxspringsample.spring.db.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import de.davidartmann.javafxspringsample.spring.db.model.Text;

public interface TextRepository extends Repository<Text, Long> {
	
	/*
	 * Default CRUD ops
	 */	
	void delete(Text text);
	
	void deleteAll();
	
	List<Text> findAll();

	Text findOne(Long id);
	
	Text save(Text text);
	
	Long count();
	
	boolean exists(Long id);
	
	/*
	 * Named queries
	 * http://docs.spring.io/spring-data/data-commons/docs/1.12.2.RELEASE/reference/html/
	 */
	List<Text> findByTitle(String title);
}
