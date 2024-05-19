package com.example.HomeTask14;

import com.example.HomeTask14.data.entity.Note;
import com.example.HomeTask14.service.exeption.NoteNotFoundException;
import com.example.HomeTask14.service.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeTask14ApplicationTests {
	private DemoApplication demoApplication;
	@Autowired
	private NoteService noteService;

	@Test
	void testGetAllNote(){
		noteService.listAll();
	}

	@Test
	void testAddNote() {
		Note note = new Note();
		note.setTitle("Test");
		note.setContent("Test");
		noteService.add(note);
	}

	@Test
	void testGetNoteById() throws NoteNotFoundException {
		Note note = new Note();
		note.setTitle("Test");
		note.setContent("Test");
		noteService.add(note);
		noteService.getById(note.getId());
	}

	@Test
	void testDeleteNoteById() throws NoteNotFoundException {
		Note note = new Note();
		note.setTitle("Test");
		note.setContent("Test");
		noteService.add(note);
		noteService.deleteById(note.getId());
	}

	@Test
	void testUpdateNoteById() throws NoteNotFoundException {
		Note note = new Note();
		note.setTitle("Test");
		note.setContent("Test");
		noteService.add(note);
		noteService.update(note);
	}

}
