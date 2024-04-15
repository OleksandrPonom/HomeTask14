package com.example.HomeTask14.service;

import com.example.HomeTask14.entity.Note;
import com.example.HomeTask14.exeption.NoteNotFoundException;
import com.example.HomeTask14.repository.NoteFakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/*

В сервісі мають бути наступні методи:




    void update(Note note) - шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.


Використай анотацію @Service, щоб зробити цей клас Spring Bean.

*/

@Service
public class NoteServiceImplement implements NoteService {

	@Autowired
	private NoteFakeRepository noteFakeRepository;

	@Override
	public List<Note> listAll() {
		return noteFakeRepository.listAllNotes();
	}

	@Override
	public Note add(Note note) {
		return noteFakeRepository.addNote(note);
	}

	@Override
	public void deleteById(UUID id) throws NoteNotFoundException {
		Optional<Note> note = getById(id);
		if (!note.isPresent()) {
			throw new NoteNotFoundException(id);
		}

		noteFakeRepository.deleteByIdNote(id);
	}

	@Override
	public void update(Note note) throws NoteNotFoundException {
		if (Objects.isNull(note.getId())) {
			throw new NoteNotFoundException();
		}

		noteFakeRepository.updateNote(note);
	}

	@Override
	public Optional<Note> getById(UUID id) throws NoteNotFoundException {
		Optional<Note> note = noteFakeRepository.getByIdNote(id);
		if (note.isPresent()) {
			return note;
		} else {
			throw new NoteNotFoundException(id);
		}
	}
}
