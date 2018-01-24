package org.personal.table.service;

import org.personal.table.model.Note;

import java.util.List;

public interface NoteService {

    /**
     * @param id
     * @return
     */

    Note getNote(Long id);

    /**
     * @param userId
     * @return
     */
    
    List<Note> getUserNotes(Long userId);

}
