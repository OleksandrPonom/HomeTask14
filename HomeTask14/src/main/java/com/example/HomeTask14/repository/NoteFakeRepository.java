package com.example.HomeTask14.repository;

import com.example.HomeTask14.entity.Note;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NoteFakeRepository {

	private final List<Note> notes = new ArrayList<>();

	public Note addNote(Note note){
		note.setId(UUID.randomUUID());
		this.notes.add(note);
		return note;
	}

	public void updateNote(Note note){
		Optional<Note> optionalNote = this.notes.stream()
				.filter(n -> n.getId().equals(note.getId()))
				.findFirst();
		if (optionalNote.isPresent()){
			Note note1 = optionalNote.get();
			note1.setTitle(note.getTitle());
			note1.setContent(note.getContent());
			notes.add(note1);
		}
	}

	public List<Note> listAllNotes() {
		return this.notes;
	}

	public Optional<Note> getByIdNote(UUID id) {
		return this.notes.stream()
				.filter(note -> note.getId().equals(id))
				.findFirst();
	}

	public void deleteByIdNote(UUID id){
		this.notes.stream()
				.filter(note -> note.getId().equals(id))
				.findFirst()
				.ifPresent(this.notes::remove);
	}
}
