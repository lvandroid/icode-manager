package com.bsty.icode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TeacherParamDTO extends ParamDTO {
    private String name;//按名称搜索
    private String courseName; //课程名称
    private long courseTypeId; //按课程类型搜索

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
