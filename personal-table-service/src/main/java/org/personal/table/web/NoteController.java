package org.personal.table.web;

import lombok.AllArgsConstructor;
import org.personal.table.model.Note;
import org.personal.table.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    private final NoteService noteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Note> returnHello(@PathVariable("id") Long id) {
        return ResponseEntity.ok(noteService.getNote(id));
    }

}
