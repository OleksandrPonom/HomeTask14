package com.example.HomeTask14.service;

import com.example.HomeTask14.entity.Note;
import com.example.HomeTask14.exeption.NoteNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteService {

	List<Note> listAll();

	Note add(Note note);

	void deleteById(UUID id) throws NoteNotFoundException;

	void update(Note note) throws NoteNotFoundException;

	Optional<Note> getById(UUID id) throws NoteNotFoundException;
}