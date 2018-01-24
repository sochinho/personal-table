package org.personal.table.repository;

import org.personal.table.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    public Optional<Note> findById(Long id);

    public List<Note> findByUserId(Long id);
}
