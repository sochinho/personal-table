package org.personal.table.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NoteDto {

    private String title;

    private String type;

    private String description;

    private Date deadline;

    private Long userId;

}
