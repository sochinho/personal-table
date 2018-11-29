package org.personal.table.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.personal.table.utils.DateUtils;

import java.util.Date;

@Data
@Builder
public class NoteDto {

    private String title;

    private String type;

    private String description;

    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    private Date deadline;

    private Long userId;

}
