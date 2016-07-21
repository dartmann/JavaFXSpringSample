package de.davidartmann.javafxspringsample.spring.db.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import de.davidartmann.javafxspringsample.spring.TestContext;
import de.davidartmann.javafxspringsample.spring.db.model.Text;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@Transactional
public class TestRepos {
	
	@Autowired
	private TextRepository textRepository;
	
	@Rollback
	private Text createTextInDb() {
		Text text = new Text();
		text.setTitle("test title");
		text.setDescription("test desc");
		return textRepository.save(text);
	}
	
	@Test
	public void testContext() {
		assertNotNull(textRepository);
	}
	
	@Test
	public void testRepoFindAll() {
		List<Text> texts = textRepository.findAll();
		assertNotNull(texts);
	}
	
	@Test
	public void testRepoSaveAndCount() {
		textRepository.deleteAll();
		List<Text> texts = new ArrayList<>();
		int randInt = new Random().nextInt(10);
		int i = 0;
		for (; i < randInt; i++) {
			texts.add(createTextInDb());
		}
		assertEquals(i, texts.size());
		assertEquals((long) i, (long) textRepository.count());
	}
	
	@Test
	public void testRepoExistsAndDelete() {
		Text text = textRepository.save(createTextInDb());
		assertEquals(true, textRepository.exists(text.getId()));
		textRepository.delete(text);
		assertNull(textRepository.findOne(text.getId()));
	}
	
	@Test
	public void testRepoFindOne() {
		Text text = textRepository.save(createTextInDb());
		Text text2 = textRepository.findOne(text.getId());
		assertEquals(text, text2);
	}

	@Test
	public void testCreationDate() {
		Text text = textRepository.save(createTextInDb());
		assertNotEquals(new Date(), text.getCreationTime());
		assertEquals(text.getCreationTime(), textRepository.findOne(text.getId()).getCreationTime());
	}
	
	@Test
	public void testModificationTime() {
		Text text = textRepository.save(createTextInDb());
		text.setDescription("new test desc");
		text = textRepository.save(text);
		assertNotEquals(new Date(), text.getModificationTime());
		assertEquals(text.getModificationTime(), textRepository.findOne(text.getId()).getModificationTime());
	}
}
