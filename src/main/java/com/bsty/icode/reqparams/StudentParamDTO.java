package com.bsty.icode.reqparams;

import com.bsty.icode.dto.ParamDTO;
import lombok.Data;

@Data
public class StudentParamDTO extends ParamDTO {
    private String id;
    private String phone;
    private String name;
    private int sex;
    private String grade;
    private String genearchId; //家长id
    private String genearchName; //家长姓名
    private String genearchPhone; //家长手机号
    private String genearchRelation; //家长关系
    private String mark;
    private boolean enable;//是否激活，报名课程成功为激活
    private String referId;//推荐人id

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
