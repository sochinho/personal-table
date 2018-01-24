package org.personal.table.model;

import org.personal.table.model.enums.NoteType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private NoteType type;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadLine;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private User user;

}
