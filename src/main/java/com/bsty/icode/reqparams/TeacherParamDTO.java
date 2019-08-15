package com.bsty.icode.reqparams;

import com.bsty.icode.dto.ParamDTO;
import lombok.Data;

@Data
public class TeacherParamDTO extends ParamDTO {
    private String name;//按名称搜索
    private String courseName; //课程名称
    private String courseTypeNames; //课程名称
    private int sex;
    private String phone;
    private long courseTypeId; //按课程类型搜索

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
