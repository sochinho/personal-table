package org.personal.table.service;

import org.personal.table.exception.NoNoteException;
import org.personal.table.model.Note;

public interface NoteService {

    /**
     * @param id
     * @return
     */

    public Note getNote(Long id) ;

}
