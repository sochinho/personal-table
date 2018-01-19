package org.personal.table.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.personal.table.exception.NoNoteException;
import org.personal.table.model.Note;
import org.personal.table.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note getNote(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new NoNoteException("No note with specified ID."));
    }
}
