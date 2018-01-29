package org.personal.table.service;

import org.personal.table.dto.NoteDto;
import org.personal.table.model.Note;

import java.util.List;

public interface NoteService {

    /**
     * @param id
     * @return
     */

    NoteDto getNote(Long id);

    /**
     * @param userId
     * @return
     */

    List<NoteDto> getUserNotes(Long userId);

}
