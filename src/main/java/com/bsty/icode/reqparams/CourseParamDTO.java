package com.bsty.icode.reqparams;

import com.bsty.icode.dto.ParamDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
