package com.bsty.icode.reqparams;

import com.bsty.icode.dto.ParamDTO;
import lombok.Data;

@Data
public class StaffParamsDTO extends ParamDTO {
    private long id;
    private long userId;
    private String name;
    private String nickName;
    private String nameEn;
    private String phone;
    private String phoneCompany;
    private long sex;
    private String idCardNo;
    private String idCardAddress;
    private String birthday;
    private String email;
    private String addressNow;
    private String famousFamily;
    private String politicalStatus;
    private int married;
    private String graduatedSchool;
    private String profession;
    private String education;
    private String trainExperience;
    private String entryDate;
    private String turnPositiveDate;
    private String payrollCard;
    private String payRollCardBank;
    private String emergencyOneName;
    private String emergencyOnePhone;
    private String emergencyTwoName;
    private String emergencyTwoPhone;
    private String parentName;
    private String parentIdCard;
    private String parentCardNo;
    private String parentCardBank;
    private String mark;

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
