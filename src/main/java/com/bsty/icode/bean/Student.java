package com.bsty.icode.bean;

import com.bsty.icode.dto.StudentDTO;
import lombok.Data;

@Data
public class Student {
    private String id;
    private String phone;
    private String name;
    private int sex;
    private long updateDate;
    private String grade;
    private String genearchId; //家长id
    private String mark;
    private boolean enable;//是否激活，报名课程成功为激活
    private String referId;//推荐人id

}
