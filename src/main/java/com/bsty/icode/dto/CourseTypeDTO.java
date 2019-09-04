package com.bsty.icode.dto;


import com.bsty.icode.bean.CourseType;
import lombok.Data;

@Data
public class CourseTypeDTO {
    private long id;
    private String name;
    private int type;

    public CourseTypeDTO() {
    }

    public CourseTypeDTO(CourseType courseType) {
        if (courseType != null) {
            this.id = courseType.getId();
            this.name = courseType.getName();
//            this.type = courseType.getType();
        }
    }
}
