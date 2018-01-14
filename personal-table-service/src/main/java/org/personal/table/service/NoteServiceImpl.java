package org.personal.table.service;

import org.personal.table.exception.NoNoteException;
import org.personal.table.model.Note;
import org.personal.table.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note getNote(Long id) throws NoNoteException {

        return noteRepository.findById(id).orElseThrow(() -> new NoNoteException("No note with specified ID."));
    }
}
