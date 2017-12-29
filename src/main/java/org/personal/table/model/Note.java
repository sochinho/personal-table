package org.personal.table.model;

import javax.persistence.Entity;

@Entity
public class Note extends BaseEntity {

    private String description;

    private User user;

}
