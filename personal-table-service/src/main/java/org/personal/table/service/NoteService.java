package org.personal.table.service;

import org.personal.table.exception.NoNoteException;
import org.personal.table.model.Note;

public interface NoteService {

    public Note getNote(Long id) throws NoNoteException;

}
