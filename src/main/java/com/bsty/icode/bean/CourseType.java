package com.bsty.icode.bean;

import com.bsty.icode.dto.CourseTypeDTO;
import lombok.Data;

@Data
public class CourseType {
    private long id;
    private String name;

    public CourseType() {
    }

    public CourseType(CourseTypeDTO dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.name = dto.getName();
        }
    }
}
