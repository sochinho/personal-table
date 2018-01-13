package org.personal.table.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "user_token")
    private String userToken;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Note> notes;

}
