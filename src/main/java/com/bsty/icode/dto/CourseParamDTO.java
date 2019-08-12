package com.bsty.icode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class CourseParamDTO extends ParamDTO {
    private String name;
    private String order;//排序规则

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
